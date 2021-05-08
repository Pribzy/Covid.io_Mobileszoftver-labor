package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.pribelszki.covidio.R

class CountryDetailsOverallFragment: RainbowCakeFragment<CountryDetailsOverallState, CountryDetailsOverallViewModel>() {

    override fun getViewResource() = R.layout.fragment_country_details_overall

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: CountryDetailsOverallState) {
        // TODO: Add render method
    }
}