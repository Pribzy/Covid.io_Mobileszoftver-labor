package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import hu.bme.aut.pribelszki.covidio.R
import kotlinx.android.synthetic.main.fragment_country_list.*

class CountryDetailsDeathFragment : RainbowCakeFragment<CountryDetailsDeathState, CountryDetailsDeathViewModel>() {

    override fun getViewResource() = R.layout.fragment_country_details_death

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: CountryDetailsDeathState) {
        // TODO: Add render method
    }
}