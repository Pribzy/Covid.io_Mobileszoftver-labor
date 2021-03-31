package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import retrofit2.http.*

interface CovidNetworkAPI {
    @GET("/summary")
    suspend fun getCases(): CovidCases

    @GET("/total/dayone/country/{countryName}")
    suspend fun getCountryStatuses(@Path("countryName") countryName: String): List<CountryStatus>

    @DELETE("/countries/{countryId}")
    suspend fun healCountry(@Path("countryId") countryId: String)

    @POST("/cases")
    suspend fun addCase(case: NewCase)
}