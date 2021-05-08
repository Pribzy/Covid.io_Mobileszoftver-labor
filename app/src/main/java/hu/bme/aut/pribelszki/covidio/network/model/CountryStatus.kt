package hu.bme.aut.pribelszki.covidio.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed.Case
import hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed.CountByDaysPresentationModel

@JsonClass(generateAdapter = true)
data class CountryStatus(
    @Json(name = "Country") val country: String,
    @Json(name = "CountryCode") val countryCode: String,
    @Json(name = "Province") val province: String,
    @Json(name = "City") val city: String,
    @Json(name = "CityCode") val cityCode: String,
    @Json(name = "Lat") val latitude: String,
    @Json(name = "Lon") val longitude: String,
    @Json(name = "Confirmed") val confirmed: Int,
    @Json(name = "Deaths") val deaths: Int,
    @Json(name = "Recovered") val recovered: Int,
    @Json(name = "Active") val active: Int,
    @Json(name = "Date") val date: String
)

fun List<CountryStatus>.toCountByDayPresentationModel(statusType: StatusType): CountByDaysPresentationModel {
    return CountByDaysPresentationModel(
        totalCount = if (statusType == StatusType.Confirmed) last().confirmed else last().deaths,
        yesterdayCount = getLast(1, statusType),
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