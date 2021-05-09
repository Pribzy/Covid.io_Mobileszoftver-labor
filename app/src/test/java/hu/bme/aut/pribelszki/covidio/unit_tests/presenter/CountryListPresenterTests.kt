package hu.bme.aut.pribelszki.covidio.unit_tests.presenter

import co.zsmb.rainbowcake.test.base.PresenterTest
import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryListItemModel
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.screen.country.list.CountryListPresenter
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
class CountryListPresenterTests: PresenterTest() {
    @Inject
    lateinit var presenter: CountryListPresenter

    @Before
    fun setup() {
        Injector.inject(this)
    }

    @Test
    fun test_getCountries_isNotEmpty() = runBlockingTest {
        /* Given */
        val countries = presenter.getCountries()
        /* When */

        /* Then */
        Assert.assertFalse(countries.isEmpty())
    }

    @Test
    fun test_getCountriesWithFiltering_returnWith_nothing() = runBlockingTest {
        /* Given */
        val countries = presenter.getFilteredCountries("not existing predicate")
        /* When */

        /* Then */
        Assert.assertTrue(countries.isEmpty())
    }
    @Test
    fun test_getCountriesWithFiltering_returnWith_filteredCountries() = runBlockingTest {
        /* Given */
        val countries = presenter.getFilteredCountries("country")
        /* When */

        /* Then */
        Assert.assertFalse(countries.isEmpty())
    }

    @Test
    fun test_countryHealing_returnWith_healedCountryId() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val healedCountry = HealedCountry(id = countryId, healedDate = "date")
        val healedCountryId = presenter.healCountry(healedCountry)
        /* When */

        /* Then */
        Assert.assertEquals(countryId, healedCountryId)
    }

    @Test
    fun test_addCountryToFavourites_returnWith_favouriteCountryId() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val favouriteCountry = FavouriteCountry(id = countryId, countryName = "TestCountry")
        val addedCountryId = presenter.addFavourite(favouriteCountry)
        /* When */

        /* Then */
        Assert.assertEquals(countryId, addedCountryId)
    }

    @Test
    fun test_removeCountryToFavourites_isSuccessful() = runBlockingTest {
        /* Given */
        val countryId = "1"
        val favouriteCountry = FavouriteCountry(id = countryId, countryName = "TestCountry")
        val deleteIsSuccessful = presenter.removeFavourite(favouriteCountry)
        /* When */

        /* Then */
        Assert.assertTrue(deleteIsSuccessful)
    }

}