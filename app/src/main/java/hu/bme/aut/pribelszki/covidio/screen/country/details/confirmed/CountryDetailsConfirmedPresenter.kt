package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import javax.inject.Inject

class CountryDetailsConfirmedPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getConfirmedStatuses(countryName: String): List<CountryStatus> = withIOContext {
        countryDetailsInteractor.getCountryStatuses(countryName, StatusType.confirmed)
    }
}
