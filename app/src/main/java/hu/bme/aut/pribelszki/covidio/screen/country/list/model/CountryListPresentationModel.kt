package hu.bme.aut.pribelszki.covidio.screen.country.list.model

data class CountryListPresentationModel(
    val id: String,
    val countryName: String,
    val countryCode: String,
    val confirmedCount: Int,
    val recoveredCount: Int,
    val deathCount: Int,
    val isFavourite: Boolean
)
