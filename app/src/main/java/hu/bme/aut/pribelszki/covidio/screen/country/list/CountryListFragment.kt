package hu.bme.aut.pribelszki.covidio.screen.country.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.domain.model.CountryListItem
import hu.bme.aut.pribelszki.covidio.screen.country.details.CountryDetailsActivity
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

        setupSearchListeners()

        magnifierImageButton.setOnClickListener {
            searchingLayout.isGone = false
            titleLayout.isGone = true
            searchView.onActionViewExpanded()
        }
    }

    override fun render(viewState: CountryListViewState) {
        when (viewState) {
            is Loading -> loadingAnimation.isVisible = true
            is DataReady -> {
                loadingAnimation.isVisible = false
                adapter.submitList(viewState.countryList)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onItemSelected(item: CountryListItem) {
        val intent = Intent(context, CountryDetailsActivity::class.java)
        intent.putExtra("countryName", item.countryName)
        intent.putExtra("countryCode", item.countryCode)
        intent.putExtra("countryId", item.countryIdentifier)
        startActivity(intent)
    }

    override fun onFavouriteTapped(item: CountryListItem, isFavourite: Boolean) {
        if (isFavourite) viewModel.addFavourite(item) else viewModel.removeFavourite(item)
    }

    override fun onHealTapped(item: CountryListItem) {
        viewModel.healCountry(item)
    }

    private fun setupSearchListeners() {
        searchView.setOnQueryTextFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.loadCases()
                searchingLayout.isGone = true
                titleLayout.isGone = false
            }
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.loadFilteredCases(query)
                return false
            }

        })
    }
}