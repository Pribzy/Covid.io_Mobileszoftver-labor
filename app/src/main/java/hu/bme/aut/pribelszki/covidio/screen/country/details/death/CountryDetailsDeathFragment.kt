package hu.bme.aut.pribelszki.covidio.screen.country.details.death

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.github.aachartmodel.aainfographics.aachartcreator.*
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.Case
import hu.bme.aut.pribelszki.covidio.util.DECIMAL_FORMAT
import hu.bme.aut.pribelszki.covidio.util.formatValue
import kotlinx.android.synthetic.main.fragment_country_details_confirmed.*
import kotlinx.android.synthetic.main.fragment_country_details_death.*
import kotlinx.android.synthetic.main.fragment_country_list.loadingAnimation

class CountryDetailsDeathFragment : RainbowCakeFragment<CountryDetailsDeathState, CountryDetailsDeathViewModel>() {

    private lateinit var aaChartView: AAChartView

    private val aaChartModel = AAChartModel()
        .chartType(AAChartType.Area)
        .animationDuration(5)
        .backgroundColor("#F4F4F4")
        .gradientColorEnable(true)
        .xAxisLabelsEnabled(false)
        .dataLabelsEnabled(false)
        .yAxisTitle("Cases")
        .legendEnabled(false)
        .series(
            arrayOf(
                AASeriesElement()
                    .name("Deaths")
                    .data(arrayOf())
                    .color("#505050")
            )
        )

    override fun getViewResource() = R.layout.fragment_country_details_death

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aaChartView = requireActivity().findViewById(R.id.deathsChartView)
        aaChartView.aa_drawChartWithChartModel(aaChartModel)
        val countryId = activity?.intent?.getStringExtra("countryId")
        if (countryId != null) {
            viewModel.loadStatus(countryId)
        }
    }

    override fun render(viewState: CountryDetailsDeathState) {
        when (viewState) {
            is Loading -> loadingAnimation.isVisible = true
            is DetailsStatusesArrived -> {
                loadingAnimation.isVisible = false
                totalDeathTextView.text = formatValue(viewState.countByDaysStatuses.totalCount, DECIMAL_FORMAT)
                todayDeathTextView.text = formatValue(viewState.countByDaysStatuses.todayCount, DECIMAL_FORMAT)
                yesterdayDeathTextView.text = formatValue(viewState.countByDaysStatuses.yesterdayCount, DECIMAL_FORMAT)
                lastThreeMonthDeathTextView.text = formatValue(viewState.countByDaysStatuses.threeMonthCount, DECIMAL_FORMAT)
                updateChart(viewState.countByDaysStatuses.cases)
            }
        }
    }

    private fun updateChart(cases: List<Case>) {
        aaChartView.aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(
            arrayOf(
                AASeriesElement()
                    .name("Deaths")
                    .data(cases.map { it.count }.toTypedArray())
                    .color("#505050")
            )
        )
    }
}