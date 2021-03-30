package hu.bme.aut.pribelszki.covidio.screen.country.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsViewModel @Inject constructor(
    private val countryDetailsPresenter: CountryDetailsPresenter
): RainbowCakeViewModel<CountryDetailsState>(Initial) {
    fun loadStatus(countryName: String) = execute {
        viewState = try {
            val countryStatus = countryDetailsPresenter.getCountryStatus(countryName)
            CountryStatusArrived(countryStatus)
        } catch (e: Exception) {
            NetworkError
        }
    }
}