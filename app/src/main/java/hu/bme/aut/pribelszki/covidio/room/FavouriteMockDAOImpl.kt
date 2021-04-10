package hu.bme.aut.pribelszki.covidio.room

import timber.log.Timber

class FavouriteMockDAOImpl: FavouriteMockDAO {
    override suspend fun addFavourite(newCountry: FavouriteCountry) {
        Timber.tag("Country added to favourite list.").v(newCountry.countryId.toString())
    }

    override suspend fun removeFavourite(deletedCountry: FavouriteCountry) {
        Timber.tag("Country deleted from favourite list.").v(deletedCountry.countryId.toString())
    }
}