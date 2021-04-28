package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.domain.model.toFavouriteRoomModel
import hu.bme.aut.pribelszki.covidio.domain.model.toHealedRoomModel
import hu.bme.aut.pribelszki.covidio.util.formattedNow
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
) : RainbowCakeViewModel<CountryListViewState>(Initial) {

    fun loadCases() = execute {
        viewState = Loading
        viewState = try {
            DataReady(countryListPresenter.getCountries())
        } catch (e: Exception) {
            NetworkError
        }
    }

    fun healCountry(healedCountry: CountryListItem) = execute {
        handleHealedCountry(healedCountry)
    }

    fun addFavourite(newCountry: CountryListItem) = execute {
        handleFavouriteItem(newCountry, true)
    }

    fun removeFavourite(deletedCountry: CountryListItem) = execute {
        handleFavouriteItem(deletedCountry, false)
    }

    fun loadFilteredCases(countryName: String) = execute {
        viewState = Loading
        viewState = try {
            DataReady(countryListPresenter.getFilteredCountries(countryName))
        } catch (e: Exception) {
            NetworkError
        }
    }

    private fun handleHealedCountry(healedCountry: CountryListItem) = execute  {
        viewState = Loading
        val list = (viewState as DataReady).countryList
        list.lastIndexOf(healedCountry).let {
            list[it].isHealed = true
            list[it].healedDate = formattedNow()
        }
        countryListPresenter.healCountry(healedCountry.toHealedRoomModel())
        viewState = DataReady(list)
    }

    private fun handleFavouriteItem(countryItem: CountryListItem, to: Boolean) = execute {
        viewState = Loading
        val list = (viewState as DataReady).countryList
        list.lastIndexOf(countryItem).let { list[it].isFavourite = to }
        if (to) countryListPresenter.addFavourite(countryItem.toFavouriteRoomModel()) else countryListPresenter.removeFavourite(
            countryItem.toFavouriteRoomModel()
        )
        viewState = DataReady(list)
    }
}