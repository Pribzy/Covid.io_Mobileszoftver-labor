package hu.bme.aut.pribelszki.covidio.di

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.bme.aut.pribelszki.covidio.unit_tests.interactor.CountryDetailsInteractorTests
import hu.bme.aut.pribelszki.covidio.unit_tests.interactor.CountryListInteractorTests
import hu.bme.aut.pribelszki.covidio.unit_tests.interactor.NewCaseInteractorTests
import hu.bme.aut.pribelszki.covidio.unit_tests.presenter.CountryListPresenterTests
import hu.bme.aut.pribelszki.covidio.unit_tests.presenter.CountryOverallDetailsPresenterTests
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        RainbowCakeModule::class,
        MockNetworkModule::class,
        MockRoomModule::class
    ]
)
@ExperimentalCoroutinesApi
interface TestComponent : AppComponent {
    // Interactors
    fun inject(countryListInteractorTests: CountryListInteractorTests)
    fun inject(newCaseInteractorTests: NewCaseInteractorTests)
    fun inject(countryDetailsInteractorTests: CountryDetailsInteractorTests)

    // Presenters
    fun inject(countryListPresenterTests: CountryListPresenterTests)
    fun inject(countryOverallDetailsPresenterTests: CountryOverallDetailsPresenterTests)
}