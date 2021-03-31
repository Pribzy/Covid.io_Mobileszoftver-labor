package hu.bme.aut.pribelszki.covidio.room

import javax.inject.Inject

class FavouriteDataSource @Inject constructor(
    private val favourtieDAO: FavourtieDAO
) {
    suspend fun addFavourite() {
         favourtieDAO.addFavourite()
    }

    suspend fun removeFavourite() {
        favourtieDAO.removeFavourite()
    }
}