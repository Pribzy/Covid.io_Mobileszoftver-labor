package hu.bme.aut.pribelszki.covidio.di

import android.content.Context
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import dagger.Module
import hu.bme.aut.pribelszki.covidio.interactor.CountryListInteractorTests
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
    fun inject(countryListInteractorTests: CountryListInteractorTests)
}