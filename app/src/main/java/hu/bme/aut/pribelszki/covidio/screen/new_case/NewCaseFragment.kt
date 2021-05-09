package hu.bme.aut.pribelszki.covidio.screen.new_case

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.snackbar.Snackbar
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.network.model.NewCase
import hu.bme.aut.pribelszki.covidio.screen.country.details.CountryDetailsActivity
import hu.bme.aut.pribelszki.covidio.screen.country.list.DataReady
import hu.bme.aut.pribelszki.covidio.screen.country.list.Loading
import kotlinx.android.synthetic.main.activity_country_details.*
import kotlinx.android.synthetic.main.fragment_country_list.*
import kotlinx.android.synthetic.main.fragment_new_case.*

class NewCaseFragment : RainbowCakeFragment<NewCaseViewState, NewCaseViewModel>() {

    override fun getViewResource() = R.layout.fragment_new_case

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGenderDropDown()
        setupStatusDropDown()
        newCaseBackButton.setOnClickListener {
            activity?.onBackPressed()
        }

        addNewCaseButton.setOnClickListener {
            viewModel.addCase(
                NewCase(
                    name = nameInputEditText.text.toString(),
                    age = ageInputEditText.text.toString().toInt(),
                    gender = genderAutoComplete.text.toString(),
                    status = statusAutoComplete.text.toString()
                )
            )
        }
    }

    override fun render(viewState: NewCaseViewState) {
        when (viewState) {
            is CaseUploaded -> {
                val contextView = activity?.findViewById<View>(R.id.newCaseContentView)
                if (contextView != null) {
                    Snackbar.make(
                        contextView,
                        "New case created for ${viewState.createdCase?.name}.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setupGenderDropDown() {
        val genderItems = listOf("Male", "Female", "Droid", "Other")
        val genderAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, genderItems)
        genderAutoComplete.setAdapter(genderAdapter)
    }

    private fun setupStatusDropDown() {
        val statusItems = listOf("Confirmed", "Active", "Death")
        val statusAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, statusItems)
        statusAutoComplete.setAdapter(statusAdapter)
    }
}