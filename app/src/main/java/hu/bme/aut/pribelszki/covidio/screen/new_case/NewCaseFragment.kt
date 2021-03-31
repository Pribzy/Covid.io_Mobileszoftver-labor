package hu.bme.aut.pribelszki.covidio.screen.new_case

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.pribelszki.covidio.R

class NewCaseFragment: RainbowCakeFragment<NewCaseViewState, NewCaseViewModel>() {

    override fun getViewResource() = R.layout.fragment_new_case

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: NewCaseViewState) {
        // TODO: Add render method
    }
}