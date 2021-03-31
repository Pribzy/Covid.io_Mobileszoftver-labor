package hu.bme.aut.pribelszki.covidio.screen.new_case

import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.domain.NewCaseInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import javax.inject.Inject

class NewCasePresenter @Inject constructor(
    private val newCaseInteractorInteractor: NewCaseInteractor
) {
}
