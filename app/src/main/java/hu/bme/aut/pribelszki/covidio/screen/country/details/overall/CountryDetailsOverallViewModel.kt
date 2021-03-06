package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsOverallViewModel @Inject constructor(
    private val countryDetailsOverallPresenter: CountryDetailsOverallPresenter
): RainbowCakeViewModel<CountryDetailsOverallState>(Initial) {
    fun loadStatus(countryName: String) = execute {
        viewState = Loading
        viewState = try {
            val overallStatuses = countryDetailsOverallPresenter.getOverallStatuses(countryName)
            OverallStatusesArrived(overallStatuses)
        } catch (e: Exception) {
            NetworkError
        }
    }
}