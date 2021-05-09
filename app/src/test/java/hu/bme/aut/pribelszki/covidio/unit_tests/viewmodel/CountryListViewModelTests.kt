package hu.bme.aut.pribelszki.covidio.unit_tests.viewmodel

import co.zsmb.rainbowcake.test.assertObserved
import co.zsmb.rainbowcake.test.base.ViewModelTest
import co.zsmb.rainbowcake.test.observeStateAndEvents
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.mock.model.mockCountryListItemModel
import hu.bme.aut.pribelszki.covidio.room.favouriteCountry.FavouriteCountry
import hu.bme.aut.pribelszki.covidio.room.healedCountry.HealedCountry
import hu.bme.aut.pribelszki.covidio.screen.country.list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@ExperimentalCoroutinesApi
class CountryListViewModelTest : ViewModelTest() {

    companion object {
        private val mockedCountries = listOf(mockCountryListItemModel, mockCountryListItemModel)
        private val mockedFilteredCountries = listOf(mockCountryListItemModel)
        private val mockedFavouriteCountry = FavouriteCountry("id", "name")
        private val mockedHealCountry = HealedCountry("id", "2021.04.12")
        private var mockedCountryListItem = CountryListItem(
            id = "id",
            countryName = "country",
            countryCode = "C",
            countryIdentifier = "id",
            confirmedCount = 1,
            recoveredCount = 1,
            deathCount = 1,
            isFavourite = true,
            isHealed = true,
            healedDate = "2021.04.12"
        )
    }

    private lateinit var mockedCountryListPresenter: CountryListPresenter

    @Before
    fun setup() {
        mockedCountryListPresenter = mock()

        mockedCountryListPresenter.stub {
            onBlocking { getCountries() } doReturn mockedCountries
            onBlocking { getFilteredCountries("") } doReturn mockedFilteredCountries
            onBlocking { addFavourite(mockedFavouriteCountry) } doReturn mockedFavouriteCountry.id
            onBlocking { removeFavourite(mockedFavouriteCountry) } doReturn true
            onBlocking { healCountry(mockedHealCountry) } doReturn mockedHealCountry.id
        }
    }

    @Test
    fun test_getCountries_loadingAndReturnCountryList() = runBlockingTest {
        val viewModel = CountryListViewModel(mockedCountryListPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.loadCases()
            stateObserver.assertObserved(
                Initial,
                Loading,
                DataReady(
                    countryList = mockedCountries
                )
            )
        }
    }

    @Test
    fun test_getFilteredCountries_loadingAndReturnCountryList() = runBlockingTest {
        val viewModel = CountryListViewModel(mockedCountryListPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.loadFilteredCases("")
            stateObserver.assertObserved(
                Initial,
                Loading,
                DataReady(
                    countryList = mockedFilteredCountries
                )
            )
        }
    }

    @Test
    fun test_healCountry_isSuccessful() = runBlockingTest {
        val viewModel = CountryListViewModel(mockedCountryListPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.healCountry(mockedCountryListItem)
            stateObserver.assertObserved(
                Initial
            )
        }
    }

    @Test
    fun test_addFavourite_isSuccessful() = runBlockingTest {
        val viewModel = CountryListViewModel(mockedCountryListPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.addFavourite(mockedCountryListItem)
            stateObserver.assertObserved(
                Initial
            )
        }
    }

    @Test
    fun test_removeFavourite_isSuccessful() = runBlockingTest {
        val viewModel = CountryListViewModel(mockedCountryListPresenter)
        viewModel.observeStateAndEvents { stateObserver, _ ->
            viewModel.removeFavourite(mockedCountryListItem)
            stateObserver.assertObserved(
                Initial
            )
        }
    }
}