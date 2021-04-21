package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.network.NetworkDatasource
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import javax.inject.Inject

class NewCaseInteractor @Inject constructor(
    private val networkDataSource: NetworkDatasource
) {
    suspend fun addCase(newCase: NewCase) {
        networkDataSource.addCase(newCase)
    }
}