package hu.bme.aut.pribelszki.covidio.screen.new_case

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.domain.NewCaseInteractor
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import javax.inject.Inject

class NewCasePresenter @Inject constructor(
    private val newCaseInteractor: NewCaseInteractor
) {
    suspend fun addCase(newCase: NewCase): NewCase? = withIOContext {
        newCaseInteractor.addCase(newCase)
    }
}
