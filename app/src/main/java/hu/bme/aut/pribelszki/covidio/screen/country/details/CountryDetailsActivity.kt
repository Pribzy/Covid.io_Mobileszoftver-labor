package hu.bme.aut.pribelszki.covidio.screen.country.details

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.details.adapter.ViewPagerAdapter
import hu.bme.aut.pribelszki.covidio.screen.country.list.CountryListActivity
import kotlinx.android.synthetic.main.activity_country_details.*

class CountryDetailsActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)
        val countryName = intent.getStringExtra("countryName")
        val countryCode = intent.getStringExtra("countryCode")
        toolbarTextView.text = "${countryName} (${countryCode})"

        backButton.setOnClickListener {
            val intent = Intent(this, CountryListActivity::class.java)
            startActivity(intent)
        }

        setupTabLayout()
    }

    private fun setupTabLayout() {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Overall"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Confirmed"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Death"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}

