package hu.bme.aut.pribelszki.covidio.interactor

import android.util.Log
import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
    fun `test random jokes are as expected`() = runBlockingTest {
        val i = interactor.getCountries().toString()

    }
}