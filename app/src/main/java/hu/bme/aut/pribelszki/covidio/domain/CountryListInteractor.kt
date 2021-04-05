package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
    private val networkDataSource: CovidDatasource,
    private val favouriteDataSource: FavouriteDataSource
) {
    suspend fun getCountries(): CovidCases {
        return networkDataSource.getCountries()
    }

    suspend fun healCountry(countryName: String) {
        networkDataSource.healCountry(countryName)
    }

    suspend fun addFavourite() {
        favouriteDataSource.addFavourite()
    }

    suspend fun removeFavourite() {
        favouriteDataSource.removeFavourite()
    }
}