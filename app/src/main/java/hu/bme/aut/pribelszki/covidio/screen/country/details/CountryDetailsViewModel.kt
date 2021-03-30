package hu.bme.aut.pribelszki.covidio.screen.country.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.screen.country.list.*
import java.lang.Exception
import javax.inject.Inject

class CountryDetailsViewModel @Inject constructor(
    private val countryListPresenter: CountryDetailsPresenter
): RainbowCakeViewModel<CountryDetailsState>(Initial) {

}