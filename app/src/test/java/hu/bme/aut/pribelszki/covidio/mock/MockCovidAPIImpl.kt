package hu.bme.aut.pribelszki.covidio.mock

import hu.bme.aut.pribelszki.covidio.network.CovidAPI
import hu.bme.aut.pribelszki.covidio.network.model.*
import retrofit2.Response
import timber.log.Timber

class MockCovidAPIImpl: CovidAPI {
    override suspend fun getCases(): CovidCases {
        val globalCases = GlobalCases(1, 1, 1, 1, 1, 1, "2021.04.12")
        val countryCase = CountryCase("country_id", "country", "CC", "C", 1, 1, 1, 1, 1, 1, "2021.04.12", Empty())
        return CovidCases("cases_id", "", globalCases, listOf(countryCase))
    }

    override suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        val countryStatus = CountryStatus("Country", "CC", "Country Province", "City", "CC", "10", "10", 1, 1, 1, 1, "2021.04.12")
        return listOf(countryStatus)
    }

    override suspend fun healCountry(countryName: String): Response<Unit> {
        return Response.success(Unit)
    }

    override suspend fun addCase(case: NewCase): Response<Unit> {
        return Response.success(Unit)
    }

}