package hu.bme.aut.pribelszki.covidio.room.favouriteCountry

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavourtieDAO {
    @Query("SELECT * FROM favourites")
    suspend fun getAll(): List<FavouriteCountry>

    @Insert
    suspend fun addFavourite(newCountry: FavouriteCountry): Long

    @Delete
    suspend fun removeFavourite(deletedCountry: FavouriteCountry)
}