package hu.bme.aut.pribelszki.covidio.room

import timber.log.Timber

class FavouriteMockDAOImpl: FavouriteMockDAO {
    override suspend fun getAll(): List<FavouriteCountry> {
        val favouriteCountry = FavouriteCountry("id","Hungary")
        return listOf(favouriteCountry)
    }

    override suspend fun addFavourite(newCountry: FavouriteCountry) {
        Timber.tag("Country added to favourite list.").v(newCountry.id.toString())
    }

    override suspend fun removeFavourite(deletedCountry: FavouriteCountry) {
        Timber.tag("Country deleted from favourite list.").v(deletedCountry.id.toString())
    }
}