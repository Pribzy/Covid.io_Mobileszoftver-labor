package hu.bme.aut.pribelszki.covidio.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed.CountryDetailsConfirmedViewModel
import hu.bme.aut.pribelszki.covidio.screen.country.details.death.CountryDetailsDeathViewModel
import hu.bme.aut.pribelszki.covidio.screen.country.details.overall.CountryDetailsOverallViewModel
import hu.bme.aut.pribelszki.covidio.screen.country.list.CountryListViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountryListViewModel::class)
    abstract fun bindCountryListViewModel(countryListViewModel: CountryListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailsDeathViewModel::class)
    abstract fun bindCountryDetailsDeathViewModel(countryListViewModel: CountryDetailsDeathViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailsOverallViewModel::class)
    abstract fun bindCountryDetailsOverallViewModel(countryListViewModel: CountryDetailsOverallViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailsConfirmedViewModel::class)
    abstract fun bindCountryDetailsConfirmedViewModel(countryListViewModel: CountryDetailsConfirmedViewModel): ViewModel
}