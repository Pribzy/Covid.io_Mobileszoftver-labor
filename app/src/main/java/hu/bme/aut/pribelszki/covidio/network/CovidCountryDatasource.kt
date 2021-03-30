package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CovidCountry
import javax.inject.Inject

class CovidCountryDatasource @Inject constructor(
    private val covidCountryAPI: CovidCountryAPI
) {
    suspend fun getCountries(): List<CovidCountry> {
        return covidCountryAPI.getCountries()
    }
}