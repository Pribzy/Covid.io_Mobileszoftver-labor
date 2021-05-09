package hu.bme.aut.pribelszki.covidio.mock

import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavourtieDAO
import timber.log.Timber

class FavouriteMockDAOImpl: FavourtieDAO {
    override suspend fun getAll(): List<FavouriteCountry> {
        val favouriteCountry = FavouriteCountry("id","Hungary")
        return listOf(favouriteCountry)
    }

    override suspend fun addFavourite(newCountry: FavouriteCountry): Long {
        return newCountry.id.toLong()
    }

    override suspend fun removeFavourite(deletedCountry: FavouriteCountry) {}
}