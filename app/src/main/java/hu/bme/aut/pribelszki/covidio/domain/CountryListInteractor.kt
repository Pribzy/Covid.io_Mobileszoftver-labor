package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidCountryDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
    private val networkDataSource: CovidCountryDatasource
) {
    suspend fun getCountries(): CovidCases {
        return networkDataSource.getCountries()
    }
}