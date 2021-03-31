package hu.bme.aut.pribelszki.covidio.network.model

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class NewCase(val name: String,
              val gender: String,
              val age: Int,
              val status: String)