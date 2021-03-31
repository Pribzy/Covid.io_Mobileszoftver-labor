package hu.bme.aut.pribelszki.covidio.network.model

import com.squareup.moshi.*
import com.squareup.moshi.internal.Util
import java.lang.NullPointerException
import java.util.*

@JsonClass(generateAdapter = true)
data class CovidCases(
    @Json(name = "ID") val id: String,
    @Json(name = "Message") val message: String,
    @Json(name = "Global") val global: GlobalCases,
    @Json(name = "Countries") val countries: List<CountryCase>
)

@JsonClass(generateAdapter = true)
data class GlobalCases(
    @Json(name = "NewConfirmed") val newConfirmed: Int,
    @Json(name = "TotalConfirmed") val totalConfirmed: Int,
    @Json(name = "NewDeaths") val newDeaths: Int,
    @Json(name = "TotalDeaths") val totalDeaths: Int,
    @Json(name = "NewRecovered") val newRecovered: Int,
    @Json(name = "TotalRecovered") val totalRecovered: Int,
    @Json(name = "Date") val date: String
    )

@JsonClass(generateAdapter = true)
data class CountryCase(@Json(name = "ID") val id: String,
                  @Json(name = "Country") val country: String,
                  @Json(name = "CountryCode") val countryCode: String,
                  @Json(name = "Slug") val slug: String,
                  @Json(name = "NewConfirmed") val newConfirmed: Int,
                  @Json(name = "TotalConfirmed") val totalConfirmed: Int,
                  @Json(name = "NewDeaths") val newDeaths: Int,
                  @Json(name = "TotalDeaths") val totalDeaths: Int,
                  @Json(name = "NewRecovered") val newRecovered: Int,
                  @Json(name = "TotalRecovered") val totalRecovered: Int,
                  @Json(name = "Date") val date: String,
                  @Json(name = "Premium") val premium: Empty
)

@JsonClass(generateAdapter = true)
class Empty() {}