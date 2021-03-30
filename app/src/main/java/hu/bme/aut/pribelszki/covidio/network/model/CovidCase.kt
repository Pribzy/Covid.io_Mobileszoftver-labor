package hu.bme.aut.pribelszki.covidio.network.model

import com.squareup.moshi.JsonClass

// TODO: Add fields to model
@JsonClass(generateAdapter = true)
class CovidCase(val configuration: String?)