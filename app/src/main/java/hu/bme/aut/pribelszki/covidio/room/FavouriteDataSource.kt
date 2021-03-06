package hu.bme.aut.pribelszki.covidio.room

import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavourtieDAO
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedDAO
import javax.inject.Inject

class FavouriteDataSource @Inject constructor(
    private val favourtieDAO: FavourtieDAO,
    private val healedDAO: HealedDAO
) {

    suspend fun getAllFavourites(): List<FavouriteCountry> {
        return favourtieDAO.getAll()
    }

    suspend fun addFavourite(favouriteCountry: FavouriteCountry): Long {
        return favourtieDAO.addFavourite(favouriteCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry): Boolean {
        favourtieDAO.removeFavourite(deletedCountry)
        return true
    }

    suspend fun getAllHealed(): List<HealedCountry> {
        return healedDAO.getAll()
    }

    suspend fun healCountry(healedCountry: HealedCountry): Long {
        return healedDAO.heal(healedCountry)
    }
}