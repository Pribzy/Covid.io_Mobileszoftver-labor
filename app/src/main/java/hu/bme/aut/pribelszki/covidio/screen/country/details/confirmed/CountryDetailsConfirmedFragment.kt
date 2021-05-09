package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.github.aachartmodel.aainfographics.aachartcreator.*
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.details.CountryDetailsActivity
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.Case
import hu.bme.aut.pribelszki.covidio.screen.new_case.NewCaseActivity
import hu.bme.aut.pribelszki.covidio.screen.new_case.NewCaseFragment
import hu.bme.aut.pribelszki.covidio.util.DECIMAL_FORMAT
import hu.bme.aut.pribelszki.covidio.util.formatValue
import kotlinx.android.synthetic.main.fragment_country_details_confirmed.*
import kotlinx.android.synthetic.main.fragment_country_list.loadingAnimation

class CountryDetailsConfirmedFragment :
    RainbowCakeFragment<CountryDetailsConfirmedState, CountryDetailsConfirmedViewModel>() {

    private val aaChartModel = AAChartModel()
        .chartType(AAChartType.Area)
        .animationDuration(5)
        .gradientColorEnable(true)
        .backgroundColor("#F4F4F4")
        .xAxisLabelsEnabled(false)
        .dataLabelsEnabled(false)
        .yAxisTitle("Cases")
        .legendEnabled(false)
        .series(
            arrayOf(
                AASeriesElement()
                    .name("Confirmed")
                    .data(arrayOf())
                    .color("#983434")
            )
        )

    private lateinit var aaChartView: AAChartView

    override fun getViewResource() = R.layout.fragment_country_details_confirmed

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aaChartView = requireActivity().findViewById(R.id.confirmedChartView)
        aaChartView.aa_drawChartWithChartModel(aaChartModel)
        val countryId = activity?.intent?.getStringExtra("countryId")
        if (countryId != null) {
            viewModel.loadStatus(countryId)
        }
        confirmedNewCaseButton.setOnClickListener {
            val intent = Intent(context, NewCaseActivity::class.java)
            startActivity(intent)
        }
    }

    override fun render(viewState: CountryDetailsConfirmedState) {
        when (viewState) {
            is Loading -> loadingAnimation.isVisible = true
            is ConfirmedStatusesArrived -> {
                loadingAnimation.isVisible = false
                totalConfirmedTextView.text = formatValue(viewState.countByDaysStatuses.totalCount, DECIMAL_FORMAT)
                todayConfirmedTextView.text = formatValue(viewState.countByDaysStatuses.todayCount, DECIMAL_FORMAT)
                yesterdayConfirmedTextView.text = formatValue(viewState.countByDaysStatuses.yesterdayCount, DECIMAL_FORMAT)
                lastThreeMonthConfirmedTextView.text = formatValue(viewState.countByDaysStatuses.threeMonthCount, DECIMAL_FORMAT)
                updateChart(viewState.countByDaysStatuses.cases)
            }
        }
    }

    private fun updateChart(cases: List<Case>) {
        aaChartView.aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(
            arrayOf(
                AASeriesElement()
                    .name("Confirmed")
                    .data(cases.map { it.count }.toTypedArray())
                    .color("#983434")
            )
        )
    }
}