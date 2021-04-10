package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import javax.inject.Inject

class CovidDatasource @Inject constructor(
    private val covidAPI: CovidAPI
) {
    suspend fun getCountries(): CovidCases {
        return covidAPI.getCases()
    }

    suspend fun healCountry(countryName: String) {
        covidAPI.healCountry(countryName)
    }

    suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        return covidAPI.getCountryStatuses(countryName)
    }

    suspend fun addCase(newCase: NewCase) {
        covidAPI.addCase(newCase)
    }
}