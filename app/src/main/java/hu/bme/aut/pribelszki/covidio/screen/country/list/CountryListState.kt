package hu.bme.aut.pribelszki.covidio.screen.country.list

sealed class CountryListViewState

object Initial : CountryListViewState()

object Loading : CountryListViewState()

object NetworkError: CountryListViewState()