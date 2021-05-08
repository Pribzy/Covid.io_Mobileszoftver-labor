package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.toCountByDayPresentationModel
import javax.inject.Inject

class CountryDetailsConfirmedPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getConfirmedStatuses(countryName: String): CountByDaysPresentationModel {
       return countryDetailsInteractor.getCountryStatuses(countryName)
            .toCountByDayPresentationModel(StatusType.Confirmed)
    }
}
