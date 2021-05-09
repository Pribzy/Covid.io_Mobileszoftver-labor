package hu.bme.aut.pribelszki.covidio.di

import dagger.Module
import dagger.Provides
import hu.bme.aut.pribelszki.covidio.network.CovidAPI
import hu.bme.aut.pribelszki.covidio.mock.MockCovidAPIImpl
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideMockCovidApi(): CovidAPI = MockCovidAPIImpl()
}