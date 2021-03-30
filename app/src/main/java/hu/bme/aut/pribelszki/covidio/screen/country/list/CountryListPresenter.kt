package hu.bme.aut.pribelszki.covidio.screen.country.list

import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class CountryListPresenter @Inject constructor(
    private val countryListInteractor: CountryListInteractor
) {
    suspend fun getCountries(): CovidCases {
        return countryListInteractor.getCountries()
    }

    suspend fun healCountry(countryId: String) {
        countryListInteractor.healCountry(countryId)
    }

}
