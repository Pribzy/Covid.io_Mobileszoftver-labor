package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CovidCountry
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidCountryAPI {
    @GET("/latest")
    suspend fun getCountries() : List<CovidCountry>
}