package hu.bme.aut.pribelszki.covidio.di

import dagger.Module
import dagger.Provides
import hu.bme.aut.pribelszki.covidio.mock.FavouriteMockDAOImpl
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavourtieDAO
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedDAO
import hu.bme.aut.pribelszki.covidio.mock.HealedMockDAOImpl
import javax.inject.Singleton

@Module
class MockRoomModule {
    @Singleton
    @Provides
    fun providesMockHealedDAO(): HealedDAO = HealedMockDAOImpl()

    @Singleton
    @Provides
    fun providesMockFavouriteDAO(): FavourtieDAO = FavouriteMockDAOImpl()
}