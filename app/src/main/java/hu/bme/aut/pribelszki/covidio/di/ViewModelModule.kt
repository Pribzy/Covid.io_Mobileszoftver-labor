package hu.bme.aut.pribelszki.covidio.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.bme.aut.pribelszki.covidio.screen.country.details.CountryDetailsViewModel
import hu.bme.aut.pribelszki.covidio.screen.country.list.CountryListViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CountryListViewModel::class)
    abstract fun bindCountryListViewModel(countryListViewModel: CountryListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailsViewModel::class)
    abstract fun bindCountryDetailsViewModel(countryListViewModel: CountryDetailsViewModel): ViewModel
}