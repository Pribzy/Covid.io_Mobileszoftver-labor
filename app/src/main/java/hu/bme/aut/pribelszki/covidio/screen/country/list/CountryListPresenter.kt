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

    suspend fun healCountry(healedCountry: HealedCountry) = withIOContext {
        countryListInteractor.healCountry(healedCountry)
    }

    suspend fun addFavourite(newCountry: FavouriteCountry) = withIOContext {
        countryListInteractor.addFavourite(newCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry) = withIOContext {
        countryListInteractor.removeFavourite(deletedCountry)
    }

}
