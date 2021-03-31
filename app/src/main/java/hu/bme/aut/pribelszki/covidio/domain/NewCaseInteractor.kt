package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.CovidDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CovidCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import hu.bme.aut.pribelszki.covidio.room.FavouriteDataSource
import javax.inject.Inject

class NewCaseInteractor @Inject constructor(
    private val networkDataSource: CovidDatasource
) {
    suspend fun addCase(newCase: NewCase) {
        networkDataSource.addCase(newCase)
    }
}