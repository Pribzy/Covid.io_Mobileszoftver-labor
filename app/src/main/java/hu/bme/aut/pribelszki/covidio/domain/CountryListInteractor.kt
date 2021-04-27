package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.network.NetworkDatasource
import hu.bme.aut.pribelszki.covidio.room.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
        private val networkDataSource: NetworkDatasource,
        private val favouriteDataSource: FavouriteDataSource
) {
    suspend fun getCountries(): List<CountryListItem> {
        val favouriteCountryIds = favouriteDataSource.getAllFavourites()
        val vmi = favouriteCountryIds.map { it.id }
        return networkDataSource.getCountries().countries.toMutableList().map {
            CountryListItem(
                id = it.id,
                countryIdentifier = it.slug,
                countryName = it.country,
                countryCode = it.countryCode,
                confirmedCount = it.totalConfirmed,
                recoveredCount = it.totalRecovered,
                deathCount = it.totalDeaths,
                isFavourite = vmi.contains(it.id)
            )
        }
    }

    suspend fun healCountry(countryName: String) {
        networkDataSource.healCountry(countryName)
    }

    suspend fun addFavourite(newCountry: FavouriteCountry) {
        favouriteDataSource.addFavourite(newCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry) {
        favouriteDataSource.removeFavourite(deletedCountry)
    }
}