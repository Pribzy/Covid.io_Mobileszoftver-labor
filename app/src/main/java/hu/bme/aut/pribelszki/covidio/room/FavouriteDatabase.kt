package hu.bme.aut.pribelszki.covidio.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteCountry::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavourtieDAO

    companion object {
        @Volatile
        private var INSTANCE: FavouriteDatabase? = null

        fun getInstance(context: Context): FavouriteDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                        context,
                        FavouriteDatabase::class.java, "favourites_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { INSTANCE = it }
            }
        }
    }
}