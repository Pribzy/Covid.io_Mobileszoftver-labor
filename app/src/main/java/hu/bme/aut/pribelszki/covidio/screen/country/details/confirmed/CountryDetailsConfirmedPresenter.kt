package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class CountryDetailsConfirmedPresenter @Inject constructor(
    private val countryDetailsInteractor: CountryDetailsInteractor
) {
    suspend fun getConfirmedStatuses(countryName: String): ConfirmedPresentationModel {
        val countryStatuses = countryDetailsInteractor.getCountryStatuses(countryName)
        val lastCount = countryStatuses.last().confirmed
        val totalCount =  countryStatuses.sumOf { it.confirmed }
        val cases = countryStatuses.map { Case(it.date, it.confirmed) }
        return ConfirmedPresentationModel(
                totalCount = lastCount,
                yesterdayCount =  countryStatuses.getLast(1, StatusType.Confirmed),
                threeMonthCount = countryStatuses.getLast(90, StatusType.Confirmed),
                cases = countryStatuses.map { Case(it.date, it.confirmed) }
            )

    }
}

fun List<CountryStatus>.getLast(day: Int, type: StatusType): Int {
    return when(type) {
        StatusType.Overall -> 0
        StatusType.Confirmed -> (this.last().confirmed - this[this.lastIndex - day].confirmed)
        StatusType.Death -> (this.last().confirmed - this[this.lastIndex - day].confirmed)
    }
}
