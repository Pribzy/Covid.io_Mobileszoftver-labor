package hu.bme.aut.pribelszki.covidio.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.bme.aut.pribelszki.covidio.network.CovidCountryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        CovidCountryModule::class
    ]
)
interface AppComponent: RainbowCakeComponent