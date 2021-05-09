package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import javax.inject.Inject

class CountryListPresenter @Inject constructor(
    private val countryListInteractor: CountryListInteractor
) {
    suspend fun getCountries(): List<CountryListItem> = withIOContext {
        countryListInteractor.getCountries()
    }

    suspend fun getFilteredCountries(countryName: String): List<CountryListItem> = withIOContext {
        countryListInteractor.getCountries().filter {
            it.countryName.decapitalize().contains(countryName.decapitalize())
        }
    }

    suspend fun healCountry(healedCountry: HealedCountry): String = withIOContext {
        countryListInteractor.healCountry(healedCountry)
    }

    suspend fun addFavourite(newCountry: FavouriteCountry): String = withIOContext {
        countryListInteractor.addFavourite(newCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry): Boolean = withIOContext {
        countryListInteractor.removeFavourite(deletedCountry)
    }

}
