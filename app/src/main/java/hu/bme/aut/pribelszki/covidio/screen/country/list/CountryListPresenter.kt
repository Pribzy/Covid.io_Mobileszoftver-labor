package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class CountryListPresenter @Inject constructor(
    private val countryListInteractor: CountryListInteractor
) {
    suspend fun getCountries(): CovidCases = withIOContext {
        countryListInteractor.getCountries()
    }

    suspend fun healCountry(countryName: String) = withIOContext {
        countryListInteractor.healCountry(countryName)
    }

    suspend fun addFavourite() = withIOContext {
        countryListInteractor.addFavourite()
    }

    suspend fun removeFavourite() = withIOContext {
        countryListInteractor.removeFavourite()
    }

}
