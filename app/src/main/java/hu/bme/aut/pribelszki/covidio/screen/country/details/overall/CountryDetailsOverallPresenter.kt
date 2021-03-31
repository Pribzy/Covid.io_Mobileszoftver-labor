package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import javax.inject.Inject

class CountryDetailsOverallPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getOverallStatuses(countryName: String): List<CountryStatus> {
        return countryDetailsInteractor.getCountryStatuses(countryName, StatusType.overall)
    }
}
