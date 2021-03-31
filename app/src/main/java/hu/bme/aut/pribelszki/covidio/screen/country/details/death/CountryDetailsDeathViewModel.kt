package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsDeathViewModel @Inject constructor(
    private val countryDetailsDeathPresenter: CountryDetailsDeathPresenter
): RainbowCakeViewModel<CountryDetailsDeathState>(Initial) {
    fun loadStatus(countryName: String) = execute {
        viewState = try {
            val countryStatus = countryDetailsDeathPresenter.getCountryStatus(countryName)
            CountryStatusArrived(countryStatus)
        } catch (e: Exception) {
            NetworkError
        }
    }
}