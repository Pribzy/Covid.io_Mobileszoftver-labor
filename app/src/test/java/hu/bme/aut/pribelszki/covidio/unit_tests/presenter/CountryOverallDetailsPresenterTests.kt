package hu.bme.aut.pribelszki.covidio.unit_tests.presenter

import co.zsmb.rainbowcake.test.base.PresenterTest
import hu.bme.aut.pribelszki.covidio.di.Injector
import hu.bme.aut.pribelszki.covidio.domain.CountryListInteractor
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryListItemModel
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryStatus
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.toOverallPresentationModel
import hu.bme.aut.pribelszki.covidio.screen.country.details.overall.CountryDetailsOverallPresenter
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
class CountryOverallDetailsPresenterTests: PresenterTest() {
    @Inject
    lateinit var presenter: CountryDetailsOverallPresenter

    @Before
    fun setup() {
        Injector.inject(this)
    }

    @Test
    fun test_getCountryStatuses_returnWith_overAllStatuses() = runBlockingTest {
        /* Given */
        val countryOverallStatuses = presenter.getOverallStatuses("country")
        /* When */

        /* Then */
        Assert.assertEquals(countryOverallStatuses.activeCount, 1)
        Assert.assertEquals(countryOverallStatuses.confirmedCount, 1)
        Assert.assertEquals(countryOverallStatuses.recoveredCount, 1)
        Assert.assertEquals(countryOverallStatuses.activeCount, 1)
    }
}