package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsDeathViewModel @Inject constructor(
    private val countryDetailsDeathPresenter: CountryDetailsDeathPresenter
): RainbowCakeViewModel<CountryDetailsDeathState>(Initial) {
    fun loadStatus(countryName: String) = execute {
        viewState = Loading
        viewState = try {
            val deathStatuses = countryDetailsDeathPresenter.getDeathStatuses(countryName)
            DetailsStatusesArrived(deathStatuses)
        } catch (e: Exception) {
            NetworkError
        }
    }
}