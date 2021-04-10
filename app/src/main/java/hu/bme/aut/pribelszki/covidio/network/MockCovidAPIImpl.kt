package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.network.model.*

class MockCovidAPIImpl: MockCovidAPI {
    override suspend fun getCases(): CovidCases {
        val globalCases = GlobalCases(1, 1, 1, 1, 1, 1, "2021.04.12")
        val countryCase = CountryCase("country_id", "country", "CC", "C", 1, 1, 1, 1, 1, 1, "2021.04.12", Empty())
        return CovidCases("cases_id", "", globalCases, listOf(countryCase))
    }

    override suspend fun getCountryStatuses(countryName: String): List<CountryStatus> {
        val countryStatus = CountryStatus("Country", "CC", "Country Province", "City", "CC", "10", "10", 1, 1, 1, 1, "2021.04.12")
        return listOf(countryStatus)
    }

    override suspend fun healCountry(countryName: String) { }

    override suspend fun addCase(case: NewCase) { }

}