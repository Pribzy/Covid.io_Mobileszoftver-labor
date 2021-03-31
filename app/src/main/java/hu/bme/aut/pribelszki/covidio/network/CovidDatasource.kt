package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import javax.inject.Inject

class CovidDatasource @Inject constructor(
    private val covidNetworkAPI: CovidNetworkAPI
) {
    suspend fun getCountries(): CovidCases {
        return covidNetworkAPI.getCases()
    }

    suspend fun healCountry(countryId: String) {
        covidNetworkAPI.healCountry(countryId)
    }

    suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        return covidNetworkAPI.getCountryStatuses(countryName)
    }

    suspend fun addCase(newCase: NewCase) {
        covidNetworkAPI.addCase(newCase)
    }
}