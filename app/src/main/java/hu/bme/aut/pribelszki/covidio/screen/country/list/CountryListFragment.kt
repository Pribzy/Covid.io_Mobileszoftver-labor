package hu.bme.aut.pribelszki.covidio.screen.country.list

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.list.adapter.CountryListAdapter
import kotlinx.android.synthetic.main.fragment_country_list.*

class CountryListFragment : RainbowCakeFragment<CountryListViewState, CountryListViewModel>(),
    CountryListAdapter.Listener {

    private lateinit var adapter: CountryListAdapter

    override fun getViewResource() = R.layout.fragment_country_list

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CountryListAdapter(requireContext())
        adapter.listener = this
        countryListRecyclerView.adapter = adapter
        viewModel.loadCases()
    }

    override fun render(viewState: CountryListViewState) {
        when (viewState) {
            is Loading -> loadingAnimation.isVisible = true
            is DataReady -> {
                loadingAnimation.isVisible = false
                adapter.submitList(viewState.countryList)
            }
        }
    }

    override fun onItemSelected(shareName: String) {
        // TODO("Not yet implemented")
    }
}