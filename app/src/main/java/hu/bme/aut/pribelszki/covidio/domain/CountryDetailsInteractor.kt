package hu.bme.aut.pribelszki.covidio.domain

import hu.bme.aut.pribelszki.covidio.domain.model.StatusType
import hu.bme.aut.pribelszki.covidio.network.NetworkDatasource
import hu.bme.aut.pribelszki.covidio.network.model.CountryStatus
import javax.inject.Inject

class CountryDetailsInteractor @Inject constructor(
    private val networkDataSource: NetworkDatasource
) {
    suspend fun getCountryStatuses(countryName: String, type: StatusType): List<CountryStatus> {
        return networkDataSource.getCountryStatuses(countryName)
    }
}