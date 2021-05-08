package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import hu.bme.aut.pribelszki.covidio.screen.country.details.model.CountByDaysPresentationModel

sealed class CountryDetailsConfirmedState

object Initial : CountryDetailsConfirmedState()

object Loading : CountryDetailsConfirmedState()

object NetworkError: CountryDetailsConfirmedState()

data class ConfirmedStatusesArrived(val countByDaysStatuses: CountByDaysPresentationModel) : CountryDetailsConfirmedState()