package hu.bme.aut.pribelszki.covidio.mock

import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryCases
import hu.bme.aut.pribelszki.covidio.mock.model.mockGlobalCases
import hu.bme.aut.pribelszki.covidio.network.CovidAPI
import hu.bme.aut.pribelszki.covidio.network.model.*
import retrofit2.Response
import timber.log.Timber

class MockCovidAPIImpl: CovidAPI {
    override suspend fun getCases(): CovidCases {
        return CovidCases("mock_id", "mock message", mockGlobalCases, mockCountryCases)
    }

    override suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        val countryStatus = CountryStatus("Country", "CC", "Country Province", "City", "CC", "10", "10", 1, 1, 1, 1, "2021.04.12")
        return listOf(countryStatus)
    }

    override suspend fun healCountry(countryName: String): Response<Unit> {
        return Response.success(Unit)
    }

    override suspend fun addCase(case: NewCase): Response<NewCase> {
        return Response.success(case)
    }
}