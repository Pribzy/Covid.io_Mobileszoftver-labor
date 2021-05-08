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
import kotlinx.android.synthetic.main.fragment_country_list.loadingAnimation

class CountryDetailsDeathFragment : RainbowCakeFragment<CountryDetailsDeathState, CountryDetailsDeathViewModel>() {

    private lateinit var aaChartView: AAChartView

    override fun getViewResource() = R.layout.fragment_country_details_death

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aaChartView = requireActivity().findViewById(R.id.deathsChartView)
        aaChartView.aa_drawChartWithChartModel(hu.bme.aut.pribelszki.covidio.screen.country.details.death.aaChartModel)
        viewModel.loadStatus("hungary")
    }

    override fun render(viewState: CountryDetailsDeathState) {
        when (viewState) {
            is Loading -> loadingAnimation.isVisible = true
            is DetailsStatusesArrived -> {
                loadingAnimation.isVisible = false
                totalTextField.text = formatValue(viewState.countByDaysStatuses.totalCount, DECIMAL_FORMAT)
                yesterdayTextView.text = formatValue(viewState.countByDaysStatuses.yesterdayCount, DECIMAL_FORMAT)
                threeMonthTextView.text = formatValue(viewState.countByDaysStatuses.threeMonthCount, DECIMAL_FORMAT)
                updateChart(viewState.countByDaysStatuses.cases)
            }
        }
    }

    private fun updateChart(cases: List<Case>) {
        val newModel = AAChartModel()
            .chartType(AAChartType.Area)
            .animationDuration(5)
            .gradientColorEnable(true)
            .xAxisLabelsEnabled(false)
            .dataLabelsEnabled(false)
            .yAxisTitle("Cases")
            .animationType(AAChartAnimationType.EaseOutBounce)
            .categories(cases.map { it.date }.toTypedArray())
            .legendEnabled(false)
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Deaths")
                        .data(cases.map { it.count }.toTypedArray())
                        .color("#000000")
                )
            )
        aaChartView.aa_refreshChartWithChartModel(newModel)
    }
}

val aaChartModel: AAChartModel = AAChartModel()
    .chartType(AAChartType.Area)
    .dataLabelsEnabled(false)
    .animationType(AAChartAnimationType.Bounce)
    .animationDuration(5)
    .backgroundColor(R.color.recoveredBlue)
    .categories(arrayOf("Confirmed"))
    .series(
        arrayOf(
            AASeriesElement()
                .name("Confirmed")
                .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6))
        )
    )