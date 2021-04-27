package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.domain.model.toFavouriteRoomModel
import hu.bme.aut.pribelszki.covidio.domain.model.toHealedRoomModel
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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

    fun healCountry(healedCountry: CountryListItem) = execute {
        val list = (viewState as DataReady).countryList
        viewState = Loading
        val id: Int = list.lastIndexOf(healedCountry)
        id.let {
            list[it].isHealed = true
            list[it].healedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.mm.dd")).toString()
        }
        countryListPresenter.healCountry(healedCountry.toHealedRoomModel())
        viewState = DataReady(list)
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
        if (to) countryListPresenter.addFavourite(countryItem.toFavouriteRoomModel()) else countryListPresenter.removeFavourite(countryItem.toFavouriteRoomModel())
        viewState = DataReady(list)
    }
}