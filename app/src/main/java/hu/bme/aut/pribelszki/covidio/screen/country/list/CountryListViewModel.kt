package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.lang.Exception
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
): RainbowCakeViewModel<CountryListViewState>(Initial) {
    fun loadCases() = execute {
        viewState = try {
            val countryCases = countryListPresenter.getCountries()
            DataReady(countryCases)
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun healCountry(countryId: String) = execute {
        countryListPresenter.healCountry(countryId)
    }

    suspend fun addFavourite() = execute {
        countryListPresenter.addFavourite()
    }

    suspend fun removeFavourite() = execute {
        countryListPresenter.removeFavourite()
    }
}