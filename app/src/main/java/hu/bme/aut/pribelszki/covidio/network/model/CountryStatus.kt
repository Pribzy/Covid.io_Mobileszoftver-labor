package hu.bme.aut.pribelszki.covidio.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryStatus(@Json(name = "Country") val country: String,
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