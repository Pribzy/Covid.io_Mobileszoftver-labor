package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import javax.inject.Inject

class CountryDetailsConfirmedPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getConfirmedStatuses(countryName: String): List<CountryStatus> {
        return countryDetailsInteractor.getCountryStatuses(countryName, StatusType.confirmed)
    }
}
