package hu.bme.aut.pribelszki.covidio.room

import javax.inject.Inject

class FavouriteDataSource @Inject constructor(
    private val favourtieDAO: FavourtieDAO
) {

    suspend fun getAllFavourites(): List<FavouriteCountry> {
        return favourtieDAO.getAll()
    }

    suspend fun addFavourite(favouriteCountry: FavouriteCountry) {
         favourtieDAO.addFavourite(favouriteCountry)
    }

    suspend fun removeFavourite(deletedCountry: FavouriteCountry) {
        favourtieDAO.removeFavourite(deletedCountry)
    }
}