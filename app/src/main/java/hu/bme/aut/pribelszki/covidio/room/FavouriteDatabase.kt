package hu.bme.aut.pribelszki.covidio.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavourtieDAO
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedDAO

@Database(
    entities = [
        FavouriteCountry::class,
        HealedCountry::class
    ], version = 5
)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavourtieDAO
    abstract fun healedDao(): HealedDAO

    companion object {
        @Volatile
        private var INSTANCE: FavouriteDatabase? = null

        fun getInstance(context: Context): FavouriteDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    FavouriteDatabase::class.java, "covidio_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}