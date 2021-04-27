package hu.bme.aut.pribelszki.covidio.domain.model

import hu.bme.aut.pribelszki.covidio.room.FavouriteCountry

data class CountryListItem(
    val id: String,
    val countryName: String,
    val countryCode: String,
    var countryIdentifier: String,
    val confirmedCount: Int,
    val recoveredCount: Int,
    val deathCount: Int,
    var isFavourite: Boolean
)

fun CountryListItem.toRoomModel(): FavouriteCountry {
    return FavouriteCountry(
        id = this.id,
        countryName = this.countryName
    )
}

