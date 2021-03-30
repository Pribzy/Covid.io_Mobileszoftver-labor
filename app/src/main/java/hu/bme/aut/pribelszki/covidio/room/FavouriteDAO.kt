package hu.bme.aut.pribelszki.covidio.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface FavourtieDAO {
    // TODO: Change insert method
    @Query("DELETE FROM favourites")
    suspend fun addFavourite()

    // TODO: Change delete method
    @Query("DELETE FROM favourites")
    suspend fun removeFavourite()
}