package hu.bme.aut.pribelszki.covidio.unit_tests.interactor

import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.domain.NewCaseInteractor
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryCases
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
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
class NewCaseInteractorTests {
    @Inject
    lateinit var interactor: NewCaseInteractor

    @Before
    fun setup() {
        Injector.inject(this)
    }

    @Test
    fun test_addNewCase_returnWithNewCase() = runBlockingTest {
        /* Given */
        val newCase = NewCase(name = "Test name", gender = "female", age = 25, status = "Confirmed")
        val newCreatedCase = interactor.addCase(newCase)
        /* When */

        /* Then */
        Assert.assertEquals(newCase, newCreatedCase)
    }
}