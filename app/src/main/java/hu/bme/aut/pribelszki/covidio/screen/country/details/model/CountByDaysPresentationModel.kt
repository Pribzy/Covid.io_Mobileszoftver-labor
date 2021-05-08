package hu.bme.aut.pribelszki.covidio.screen.country.details.model

data class CountByDaysPresentationModel(
    val totalCount: Int,
    val yesterdayCount: Int,
    val threeMonthCount: Int,
    val cases: List<Case>
)

data class Case(
    val date: String,
    val count: Int,
)
