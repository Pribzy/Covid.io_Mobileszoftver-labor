package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.OverallPresentationModel
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.toOverallPresentationModel
import javax.inject.Inject

class CountryDetailsOverallPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getOverallStatuses(countryName: String): OverallPresentationModel = withIOContext {
        countryDetailsInteractor.getCountryStatuses(countryName).toOverallPresentationModel()
    }
}
