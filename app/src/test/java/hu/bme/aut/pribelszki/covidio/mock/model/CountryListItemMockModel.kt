package hu.bme.aut.pribelszki.covidio.mock.model

import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem

val mockCountryListItemModel = CountryListItem(
    id = "country.id",
    countryIdentifier = "country.slug",
    countryName = "country.country",
    countryCode = "country.countryCode",
    confirmedCount = 1,
    recoveredCount = 1,
    deathCount = 1,
    isFavourite = true,
    isHealed = true,
    healedDate = "2021.04.12"
)