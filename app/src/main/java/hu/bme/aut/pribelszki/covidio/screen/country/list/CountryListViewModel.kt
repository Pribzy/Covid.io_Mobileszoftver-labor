package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.room.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.domain.model.toRoomModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
) : RainbowCakeViewModel<CountryListViewState>(Initial) {
    fun loadCases() = execute {
        viewState = try {
            DataReady(countryListPresenter.getCountries())
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun healCountry(countryName: String) = execute {
        countryListPresenter.healCountry(countryName)
    }

    fun addFavourite(newCountry: CountryListItem) = execute {
        handleFavouriteItem(newCountry, true)

    }

    fun removeFavourite(deletedCountry: CountryListItem) = execute {
        handleFavouriteItem(deletedCountry, false)
    }

    private fun handleFavouriteItem(countryItem: CountryListItem, to: Boolean) = execute {
        val list = (viewState as DataReady).countryList
        viewState = Loading
        val id: Int = list.lastIndexOf(countryItem)
        id.let { list[it].isFavourite = to }
        if (to) countryListPresenter.addFavourite(countryItem.toRoomModel()) else countryListPresenter.removeFavourite(countryItem.toRoomModel())
        viewState = DataReady(list)
    }
}