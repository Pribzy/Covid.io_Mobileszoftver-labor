package hu.bme.aut.pribelszki.covidio.network

import android.content.Context
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import javax.inject.Inject

class NetworkDatasource @Inject constructor(
    private val covidAPI: CovidAPI
) {
    suspend fun getCountries(): CovidCases {
        return covidAPI.getCases()
    }

    suspend fun healCountry(countryName: String): Boolean {
        return covidAPI.healCountry(countryName).isSuccessful
    }

    suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        return covidAPI.getCountryStatuses(countryName)
    }

    suspend fun addCase(newCase: NewCase): NewCase? {
        return covidAPI.addCase(newCase).body()
    }
}