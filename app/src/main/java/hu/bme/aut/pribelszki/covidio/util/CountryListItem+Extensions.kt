package hu.bme.aut.pribelszki.covidio.util

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem

fun List<CountryListItem>.heal(country: CountryListItem) {
    lastIndexOf(country).let {
        this[it].isHealed = true
        this[it].healedDate = formattedNow()
    }
}

fun List<CountryListItem>.setFavourite(country: CountryListItem, to: Boolean) {
    lastIndexOf(country).let { this[it].isFavourite = to }
}