package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.CovidCase
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import retrofit2.http.*

interface CovidCountryAPI {
    @GET("/cases")
    suspend fun getCases(): List<CovidCase>

    @GET("/history")
    suspend fun getHistoricalCases(@Query("status") status: String, @Query("country") country: String): CovidCase

    @DELETE("/cases/{id}")
    suspend fun healCountry(@Path("id") id: Long)

    @POST("/cases")
    suspend fun addCase(case: NewCase)
}