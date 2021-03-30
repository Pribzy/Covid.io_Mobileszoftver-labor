package hu.bme.aut.pribelszki.covidio.screen.country.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class CountryListViewModel @Inject constructor(
    private val countryListPresenter: CountryListPresenter
): RainbowCakeViewModel<CountryListViewState>(Initial) {
}