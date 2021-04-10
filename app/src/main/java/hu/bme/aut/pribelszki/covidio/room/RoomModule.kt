package hu.bme.aut.pribelszki.covidio.room

import android.content.Context
import dagger.Module
import dagger.Provides
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
}