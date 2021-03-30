package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
): RainbowCakeViewModel<CountryListViewState>(Initial) {
    fun loadCountryCases() = execute {
        viewState = Loading
        //delay(1000)
        viewState = try {
            val countryCases = countryListPresenter.getCountries()
            DataReady(countryCases)
        } catch (e: Exception) {
            NetworkError
        }
    }
}