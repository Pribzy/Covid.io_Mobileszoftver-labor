package hu.bme.aut.pribelszki.covidio.screen.country.list

import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import java.lang.Exception
import kotlin.Error

sealed class CountryListViewState

object Initial : CountryListViewState()

object Loading : CountryListViewState()

data class DataReady(val countryCases: CovidCases) : CountryListViewState()

object NetworkError: CountryListViewState()