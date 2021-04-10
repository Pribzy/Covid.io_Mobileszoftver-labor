package hu.bme.aut.pribelszki.covidio.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): FavouriteDatabase = Room.databaseBuilder(
            context.applicationContext, FavouriteDatabase::class.java, "favourites_database")
    .fallbackToDestructiveMigration()
    .build()

    @Singleton
    @Provides
    fun providesFavouriteDAO(favouriteDatabase: FavouriteDatabase) = favouriteDatabase.favouriteDao()
}