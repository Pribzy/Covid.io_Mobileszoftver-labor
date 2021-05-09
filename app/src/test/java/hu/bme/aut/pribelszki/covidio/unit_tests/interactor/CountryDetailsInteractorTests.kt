package hu.bme.aut.pribelszki.covidio.unit_tests.interactor

import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryDetailsInteractor
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryCases
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryStatus
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
class CountryDetailsInteractorTests {
    @Inject
    lateinit var interactor: CountryDetailsInteractor

    @Before
    fun setup() {
        Injector.inject(this)
    }

    @Test
    fun test_getCountryStatuses_returnWith_countryStatuses() = runBlockingTest {
        /* Given */
        val countryStatuses = interactor.getCountryStatuses("country")
        /* When */

        /* Then */
        Assert.assertTrue(countryStatuses.contains(mockCountryStatus))
    }
}