package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidCountryDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCase
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
    private val networkDataSource: CovidCountryDatasource
) {
    suspend fun getCountries(): List<CovidCase> {
        return networkDataSource.getCountries()
    }
}