package hu.bme.aut.pribelszki.covidio.room.healedCountry

import timber.log.Timber
import java.time.LocalDateTime
import java.util.*

class HealedMockDAOImpl: HealedMockDAO {
    override suspend fun getAll(): List<HealedCountry> {
        val favouriteCountry = HealedCountry("id","2012.12.12")
        return listOf(favouriteCountry)
    }

    override suspend fun heal(newCountry: HealedCountry) {
        Timber.tag("Country healed.").v(newCountry.id)
    }
}