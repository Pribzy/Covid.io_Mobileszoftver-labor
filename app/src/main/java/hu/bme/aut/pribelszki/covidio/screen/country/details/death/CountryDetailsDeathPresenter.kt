package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.toCountByDayPresentationModel
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.CountByDaysPresentationModel
import javax.inject.Inject

class CountryDetailsDeathPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getDeathStatuses(countryName: String): CountByDaysPresentationModel = withIOContext {
        countryDetailsInteractor.getCountryStatuses(countryName)
            .toCountByDayPresentationModel(StatusType.Death)
    }
}
