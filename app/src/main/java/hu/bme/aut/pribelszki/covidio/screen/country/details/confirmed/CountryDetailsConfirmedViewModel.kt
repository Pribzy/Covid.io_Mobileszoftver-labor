package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsConfirmedViewModel @Inject constructor(
    private val countryDetailsPresenter: CountryDetailsConfirmedPresenter
): RainbowCakeViewModel<CountryDetailsConfirmedState>(Initial) {
    fun loadStatus(countryName: String) = execute {
        viewState = try {
            val countryStatus = countryDetailsPresenter.getCountryStatus(countryName)
            CountryStatusArrived(countryStatus)
        } catch (e: Exception) {
            NetworkError
        }
    }
}