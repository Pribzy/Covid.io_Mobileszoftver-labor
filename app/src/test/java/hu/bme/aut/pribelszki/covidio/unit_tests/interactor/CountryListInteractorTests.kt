package hu.bme.aut.pribelszki.covidio.unit_tests.interactor

import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryCases
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CountryListInteractorTests {
    @Inject
    lateinit var interactor: CountryListInteractor

    @Before
    fun setup() {
        Injector.inject(this)
    }

    @Test
    fun test_countryHealing_returnWith_healedCountryId() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val healedCountry = HealedCountry(id = countryId, healedDate = "date")
        val healedCountryId = interactor.healCountry(healedCountry)
        /* When */

        /* Then */
        Assert.assertEquals(countryId, healedCountryId)
    }

    @Test
    fun test_addCountryToFavourites_returnWith_favouriteCountryId() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val favouriteCountry = FavouriteCountry(id = countryId, countryName = "TestCountry")
        val addedCountryId = interactor.addFavourite(favouriteCountry)
        /* When */

        /* Then */
        Assert.assertEquals(countryId, addedCountryId)
    }

    @Test
    fun test_removeCountryToFavourites_isSuccessful() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val favouriteCountry = FavouriteCountry(id = countryId, countryName = "TestCountry")
        val deleteIsSuccessful = interactor.removeFavourite(favouriteCountry)
        /* When */

        /* Then */
        Assert.assertTrue(deleteIsSuccessful)
    }

    @Test
    fun test_getCountries_isNotEmpty() = runBlockingTest {
        /* Given */
        val countries = interactor.getCountries()
        /* When */

        /* Then */
        Assert.assertFalse(countries.isEmpty())
    }
}