package hu.bme.aut.pribelszki.covidio.screen.country.details

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import java.lang.Exception
import kotlin.Error

sealed class CountryDetailsState

object Initial : CountryDetailsState()

object Loading : CountryDetailsState()

data class CountryStatusArrived(val countryStatus: CountryStatus) : CountryDetailsState()

object NetworkError: CountryDetailsState()