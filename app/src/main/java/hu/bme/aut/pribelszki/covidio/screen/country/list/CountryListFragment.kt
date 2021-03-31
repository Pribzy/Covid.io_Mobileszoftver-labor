package hu.bme.aut.pribelszki.covidio.screen.country.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import hu.bme.aut.pribelszki.covidio.R
import kotlinx.android.synthetic.main.fragment_country_list.*

class CountryListFragment : RainbowCakeFragment<CountryListViewState, CountryListViewModel>() {

    override fun getViewResource() = R.layout.fragment_country_list

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: CountryListViewState) {
        // TODO: Add render method
    }
}