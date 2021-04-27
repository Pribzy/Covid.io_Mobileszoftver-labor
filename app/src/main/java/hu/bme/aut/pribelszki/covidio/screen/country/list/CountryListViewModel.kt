package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.room.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.screen.country.list.model.CountryListPresentationModel
import java.lang.Exception
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
) : RainbowCakeViewModel<CountryListViewState>(Initial) {
    fun loadCases() = execute {
        viewState = try {
            val countryCases = countryListPresenter.getCountries()
            val countryList = countryCases.countries.toMutableList().map {
                CountryListPresentationModel(
                    it.id,
                    it.country,
                    it.countryCode,
                    it.totalConfirmed,
                    it.totalRecovered,
                    it.totalDeaths,
                    true
                )
            }
            DataReady(countryList)
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun healCountry(countryName: String) = execute {
        countryListPresenter.healCountry(countryName)
    }

    suspend fun addFavourite(newCountry: FavouriteCountry) = execute {
        countryListPresenter.addFavourite(newCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry) = execute {
        countryListPresenter.removeFavourite(deletedCountry)
    }
}