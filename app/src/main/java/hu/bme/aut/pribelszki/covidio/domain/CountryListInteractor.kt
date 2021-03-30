package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class CountryListInteractor @Inject constructor(
    private val networkDataSource: CovidDatasource
) {
    suspend fun getCountries(): CovidCases {
        return networkDataSource.getCountries()
    }

    suspend fun healCountry(countryId: String) {
        networkDataSource.healCountry(countryId)
    }
}