package hu.bme.aut.pribelszki.covidio.screen.country.details.model

import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus

data class CountByDaysPresentationModel(
    val totalCount: Int,
    val todayCount: Int,
    val yesterdayCount: Int,
    val threeMonthCount: Int,
    val cases: List<Case>
)

data class Case(
    val date: String,
    val count: Int,
)

fun List<CountryStatus>.toCountByDayPresentationModel(statusType: StatusType): CountByDaysPresentationModel {
    return CountByDaysPresentationModel(
        totalCount = if (statusType == StatusType.Confirmed) last().confirmed else last().deaths,
        todayCount = getLast(1, statusType),
        yesterdayCount = getLast(2, statusType),
        threeMonthCount = getLast(90, statusType),
        cases = this.map {
            val cases = if (statusType == StatusType.Confirmed) it.confirmed else it.deaths
            Case(it.date, cases)
        }
    )
}

fun List<CountryStatus>.getLast(day: Int, type: StatusType): Int {
    return when (type) {
        StatusType.Overall -> 0
        StatusType.Confirmed -> (last().confirmed - this[lastIndex - day].confirmed)
        StatusType.Death -> (last().deaths - this[lastIndex - day].deaths)
    }
}
