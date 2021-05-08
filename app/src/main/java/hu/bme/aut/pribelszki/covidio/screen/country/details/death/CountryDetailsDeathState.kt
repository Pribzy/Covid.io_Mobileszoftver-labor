package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.CountByDaysPresentationModel
import java.lang.Exception
import kotlin.Error

sealed class CountryDetailsDeathState

object Initial : CountryDetailsDeathState()

object Loading : CountryDetailsDeathState()

object NetworkError: CountryDetailsDeathState()

data class DetailsStatusesArrived(val countByDaysStatuses: CountByDaysPresentationModel) : CountryDetailsDeathState()