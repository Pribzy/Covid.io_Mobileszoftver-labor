package hu.bme.aut.pribelszki.covidio.mock.model

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem

val mockCountryListItemModel = CountryListItem(
    id = "id",
    countryName = "country",
    countryCode = "C",
    countryIdentifier = "id",
    confirmedCount = 1,
    recoveredCount = 1,
    deathCount = 1,
    isFavourite = true,
    isHealed = true,
    healedDate = "2021.04.12"
)