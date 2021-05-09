package hu.bme.aut.pribelszki.covidio.screen.new_case

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import java.lang.Exception
import javax.inject.Inject

class NewCaseViewModel @Inject constructor(
    private val newCasePresenter: NewCasePresenter
): RainbowCakeViewModel<NewCaseViewState>(Initial) {
    fun addCase(newCase: NewCase) = execute {
        viewState = Loading
        viewState = try {
            val createdCase = newCasePresenter.addCase(newCase)
            CaseUploaded(createdCase)
        } catch (e: Exception) {
            NetworkError
        }
    }
}