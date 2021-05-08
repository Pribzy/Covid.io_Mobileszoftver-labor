package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

sealed class CountryDetailsConfirmedState

object Initial : CountryDetailsConfirmedState()

object Loading : CountryDetailsConfirmedState()

object NetworkError: CountryDetailsConfirmedState()

data class ConfirmedStatusesArrived(val countByDaysStatuses: CountByDaysPresentationModel) : CountryDetailsConfirmedState()