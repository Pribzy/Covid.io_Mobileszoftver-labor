package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import java.lang.Exception
import kotlin.Error

sealed class CountryDetailsConfirmedState

object Initial : CountryDetailsConfirmedState()

object Loading : CountryDetailsConfirmedState()

object NetworkError: CountryDetailsConfirmedState()

data class ConfirmedStatusesArrived(val countryStatus: List<CountryStatus>) : CountryDetailsConfirmedState()