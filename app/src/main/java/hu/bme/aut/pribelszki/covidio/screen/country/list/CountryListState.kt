package hu.bme.aut.pribelszki.covidio.screen.country.list

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem

sealed class CountryListViewState

object Initial : CountryListViewState()

object Loading : CountryListViewState()

object NetworkError: CountryListViewState()

data class DataReady(val countryList: List<CountryListItem>) : CountryListViewState()