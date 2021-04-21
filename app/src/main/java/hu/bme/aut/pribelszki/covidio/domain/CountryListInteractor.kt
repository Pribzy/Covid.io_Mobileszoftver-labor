package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.NetworkDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.room.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
        private val networkDataSource: NetworkDatasource,
        private val favouriteDataSource: FavouriteDataSource
) {
    suspend fun getCountries(): CovidCases {
        return networkDataSource.getCountries()
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