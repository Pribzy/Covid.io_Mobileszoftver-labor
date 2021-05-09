package hu.bme.aut.pribelszki.covidio.mock.model

import hu.bme.aut.pribelszki.covidio.network.model.CountryCase
import hu.bme.aut.pribelszki.covidio.network.model.Empty
import hu.bme.aut.pribelszki.covidio.network.model.GlobalCases

val mockGlobalCases = GlobalCases(1,
    1,
    1,
    1,
    1,
    1,
    "2021.04.12")
val mockCountryCases =
    listOf(
        CountryCase(
            "country_id",
            "country",
            "code",
            "slug",
            1,
            1,
            1,
            1,
            1,
            1,
            "2021.04.12",
            Empty()
        )
    )