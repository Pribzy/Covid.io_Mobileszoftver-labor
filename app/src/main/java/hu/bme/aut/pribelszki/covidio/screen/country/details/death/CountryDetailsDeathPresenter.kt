package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import javax.inject.Inject

class CountryDetailsDeathPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getCountryStatus(countryName: String): CountryStatus {
        return countryDetailsInteractor.getCountryStatus(countryName)
    }
}
