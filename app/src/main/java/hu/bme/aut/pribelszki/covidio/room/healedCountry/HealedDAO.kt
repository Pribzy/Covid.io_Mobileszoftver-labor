package hu.bme.aut.pribelszki.covidio.room.healedCountry

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HealedDAO {
    @Query("SELECT * FROM healed")
    suspend fun getAll(): List<HealedCountry>

    @Insert
    suspend fun heal(newCountry: HealedCountry): Long
}