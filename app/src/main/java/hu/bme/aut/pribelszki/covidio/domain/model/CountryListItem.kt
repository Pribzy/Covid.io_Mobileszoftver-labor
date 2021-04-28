package hu.bme.aut.pribelszki.covidio.domain.model

import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.util.formattedNow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class CountryListItem(
    val id: String,
    val countryName: String,
    val countryCode: String,
    var countryIdentifier: String,
    val confirmedCount: Int,
    val recoveredCount: Int,
    val deathCount: Int,
    var isFavourite: Boolean,
    var isHealed: Boolean = false,
    var healedDate: String?
)

fun CountryListItem.toFavouriteRoomModel(): FavouriteCountry {
    return FavouriteCountry(
        id = this.id,
        countryName = this.countryName
    )
}

fun CountryListItem.toHealedRoomModel(): HealedCountry {
    return HealedCountry(
        id = this.id,
        healedDate = formattedNow()
    )
}

