package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import javax.inject.Inject

class CountryDetailsInteractor @Inject constructor(
    private val networkDataSource: CovidDatasource
) {
    suspend fun getCountryStatus(countryName: String): CountryStatus {
        return networkDataSource.getCountryStatus(countryName)
    }
}