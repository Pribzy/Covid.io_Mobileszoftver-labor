package hu.bme.aut.pribelszki.covidio.screen.new_case

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewCaseViewModel @Inject constructor(
    private val newCasPresenter: NewCasePresenter
): RainbowCakeViewModel<NewCaseViewState>(Initial) {

}