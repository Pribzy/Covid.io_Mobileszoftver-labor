package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import retrofit2.Response
import retrofit2.http.*

interface CovidAPI {
    @GET("/summary")
    suspend fun getCases(): CovidCases

    @GET("/total/dayone/country/{countryName}")
    suspend fun getCountryStatuses(@Path("countryName") countryName: String): List<CountryStatus>

    @DELETE("/countries/{countryName}")
    suspend fun healCountry(@Path("countryName") countryName: String): Response<Unit>

    @POST("/cases")
    suspend fun addCase(@Body case: NewCase): Response<NewCase>
}