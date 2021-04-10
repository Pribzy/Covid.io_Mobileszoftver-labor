package hu.bme.aut.pribelszki.covidio.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouriteCountry::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavourtieDAO
}