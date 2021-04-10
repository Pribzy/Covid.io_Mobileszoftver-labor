package hu.bme.aut.pribelszki.covidio.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface FavourtieDAO {
    @Insert
    suspend fun addFavourite(newCountry: FavouriteCountry)

    @Delete
    suspend fun removeFavourite(deletedCountry: FavouriteCountry)
}