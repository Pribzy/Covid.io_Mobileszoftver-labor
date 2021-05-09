package hu.bme.aut.pribelszki.covidio.screen.country.details.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed.CountryDetailsConfirmedFragment
import hu.bme.aut.pribelszki.covidio.screen.country.details.death.CountryDetailsDeathFragment
import hu.bme.aut.pribelszki.covidio.screen.country.details.overall.CountryDetailsOverallFragment

class ViewPagerAdapter(
    fm: FragmentManager,
    private var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val fragment: Fragment? = null
        return when (position) {
            0 -> CountryDetailsOverallFragment()
            1 -> CountryDetailsConfirmedFragment()
            2 -> CountryDetailsDeathFragment()
            else -> fragment!!
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}