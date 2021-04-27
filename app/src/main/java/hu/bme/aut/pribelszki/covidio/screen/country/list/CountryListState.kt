package hu.bme.aut.pribelszki.covidio.screen.country.list

import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.screen.country.list.model.CountryListPresentationModel
import java.lang.Exception
import kotlin.Error

sealed class CountryListViewState

object Initial : CountryListViewState()

object Loading : CountryListViewState()

object NetworkError: CountryListViewState()

data class DataReady(val countryList: List<CountryListPresentationModel>) : CountryListViewState()