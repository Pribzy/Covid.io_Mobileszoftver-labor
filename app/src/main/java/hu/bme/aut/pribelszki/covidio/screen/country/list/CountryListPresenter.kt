package hu.bme.aut.pribelszki.covidio.screen.country.list

import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CovidCase
import javax.inject.Inject

class CountryListPresenter @Inject constructor(
    private val countryListInteractor: CountryListInteractor
) {
    suspend fun getCountries(): List<CovidCase> {
        return countryListInteractor.getCountries()
    }
}
