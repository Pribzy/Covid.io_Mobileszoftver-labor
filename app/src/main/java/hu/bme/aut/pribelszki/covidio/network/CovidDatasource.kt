package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class CovidDatasource @Inject constructor(
    private val covidAPI: CovidAPI
) {
    suspend fun getCountries(): CovidCases {
        return covidAPI.getCases()
    }

    suspend fun healCountry(countryId: Long) {
        covidAPI.healCountry(countryId)
    }
}