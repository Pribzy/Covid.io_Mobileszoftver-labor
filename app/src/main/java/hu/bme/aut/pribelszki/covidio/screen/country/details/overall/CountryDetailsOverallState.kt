package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import java.lang.Exception
import kotlin.Error

sealed class CountryDetailsOverallState

object Initial : CountryDetailsOverallState()

object Loading : CountryDetailsOverallState()

object NetworkError: CountryDetailsOverallState()

data class OverallStatusesArrived(val countryStatuses: List<CountryStatus>) : CountryDetailsOverallState()