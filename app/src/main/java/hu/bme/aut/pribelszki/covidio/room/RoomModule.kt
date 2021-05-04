package hu.bme.aut.pribelszki.covidio.room

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteMockDAO
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteMockDAOImpl
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedMockDAO
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedMockDAOImpl
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): FavouriteDatabase = FavouriteDatabase.getInstance(context)

    @Singleton
    @Provides
    fun providesFavouriteDAO(favouriteDatabase: FavouriteDatabase) = favouriteDatabase.favouriteDao()

    @Singleton
    @Provides
    fun providesMockFavouriteDAO(): FavouriteMockDAO = FavouriteMockDAOImpl()

    @Singleton
    @Provides
    fun providesHealedDAO(favouriteDatabase: FavouriteDatabase) = favouriteDatabase.healedDao()

    @Singleton
    @Provides
    fun providesMockHealedDAO(): HealedMockDAO = HealedMockDAOImpl()
}