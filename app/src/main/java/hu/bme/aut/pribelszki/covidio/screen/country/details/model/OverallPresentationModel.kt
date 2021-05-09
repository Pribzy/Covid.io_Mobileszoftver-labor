package hu.bme.aut.pribelszki.covidio.screen.country.details.model

import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus

data class OverallPresentationModel(
    val confirmedCount: Int,
    val recoveredCount: Int,
    val activeCount: Int,
    val deathCount: Int
)

fun List<CountryStatus>.toOverallPresentationModel(): OverallPresentationModel {
    return OverallPresentationModel(
        confirmedCount = last().confirmed,
        recoveredCount = last().recovered,
        deathCount = last().deaths,
        activeCount = last().active
    )
}