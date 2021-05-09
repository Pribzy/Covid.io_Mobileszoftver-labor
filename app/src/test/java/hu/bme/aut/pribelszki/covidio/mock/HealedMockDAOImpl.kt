package hu.bme.aut.pribelszki.covidio.mock

import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedDAO
import timber.log.Timber

class HealedMockDAOImpl: HealedDAO {
    override suspend fun getAll(): List<HealedCountry> {
        val favouriteCountry = HealedCountry("id","2012.12.12")
        return listOf(favouriteCountry)
    }

    override suspend fun heal(newCountry: HealedCountry): Long {
        return newCountry.id.toLong()
    }
}