package hu.bme.aut.pribelszki.covidio.unit_tests.viewmodel

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.base.ViewModelTest
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.bme.aut.pribelszki.covidio.screen.country.details.death.*
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.CountByDaysPresentationModel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@ExperimentalCoroutinesApi
class CountryDeathDetailsViewModelTest : ViewModelTest() {

    companion object {
        private val mockedConfirmedStatuses =
            CountByDaysPresentationModel(1, 1, 1, 1, listOf())

    }

    private lateinit var mockedDeathDetailsPresenter: CountryDetailsDeathPresenter

    @Before
    fun setup() {
        mockedDeathDetailsPresenter = mock()

        mockedDeathDetailsPresenter.stub {
            onBlocking { getDeathStatuses("")  } doReturn mockedConfirmedStatuses
        }
    }

    @Test
    fun test_loadStatus_returnWith_loadingAndStatuses() = runBlockingTest {
        val viewModel = CountryDetailsDeathViewModel(mockedDeathDetailsPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.loadStatus("")
            stateObserver.assertObserved(
                Initial,
                Loading,
                DetailsStatusesArrived(mockedConfirmedStatuses)
            )
        }
    }


}