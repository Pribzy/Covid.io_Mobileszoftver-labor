package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.network.NetworkDatasource
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
    private val networkDataSource: NetworkDatasource,
    private val favouriteDataSource: FavouriteDataSource
) {
    suspend fun getCountries(): List<CountryListItem> {
        val favouriteCountryIds = favouriteDataSource.getAllFavourites().map { it.id }
        favouriteDataSource.getAllFavourites()
        return networkDataSource.getCountries().countries.toMutableList().map { country ->
            CountryListItem(
                id = country.id,
                countryIdentifier = country.slug,
                countryName = country.country,
                countryCode = country.countryCode,
                confirmedCount = country.totalConfirmed,
                recoveredCount = country.totalRecovered,
                deathCount = country.totalDeaths,
                isFavourite = favouriteCountryIds.contains(country.id),
                isHealed = favouriteDataSource.getAllHealed().map { it.id }.contains(country.id),
                healedDate = favouriteDataSource.getAllHealed()
                    .find { it.id == country.id }?.healedDate
            )
        }
    }

    suspend fun healCountry(healedCountry: HealedCountry): Boolean {
        val countryHealedNetwork = networkDataSource.healCountry(healedCountry.id)
        val countryHealedDisc = favouriteDataSource.healCountry(healedCountry)
        return countryHealedNetwork and countryHealedDisc
    }

    suspend fun addFavourite(newCountry: FavouriteCountry) {
        favouriteDataSource.addFavourite(newCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry) {
        favouriteDataSource.removeFavourite(deletedCountry)
    }
}