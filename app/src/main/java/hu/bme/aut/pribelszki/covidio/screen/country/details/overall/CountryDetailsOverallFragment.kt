package hu.bme.aut.pribelszki.covidio.screen.country.details.overall

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.github.aachartmodel.aainfographics.aachartcreator.*
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.util.toRoundedString
import kotlinx.android.synthetic.main.fragment_country_details_overall.*
import kotlinx.android.synthetic.main.fragment_country_list.loadingAnimation
import kotlinx.android.synthetic.main.recyclerview_country_item.*
import kotlinx.android.synthetic.main.recyclerview_country_item.confirmedTextView
import kotlinx.android.synthetic.main.recyclerview_country_item.deathTextView

class CountryDetailsOverallFragment :
    RainbowCakeFragment<CountryDetailsOverallState, CountryDetailsOverallViewModel>() {

    private lateinit var aaChartView: AAChartView

    override fun getViewResource() = R.layout.fragment_country_details_overall

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aaChartView = requireActivity().findViewById(R.id.overallChartView)
        val countryId = activity?.intent?.getStringExtra("countryId")
        if (countryId != null) {
            viewModel.loadStatus(countryId)
        }
    }

    override fun render(viewState: CountryDetailsOverallState) {
        when (viewState) {
            is Loading -> {
                loadingAnimation.isVisible = true
                overallChartView.isVisible = false
                overallCardView.isVisible = false
            }
            is OverallStatusesArrived -> {
                loadingAnimation.isVisible = false
                overallChartView.isVisible = true
                overallCardView.isVisible = true
                val confirmedCount = viewState.overallPresentationModel.confirmedCount
                val recoveredCount = viewState.overallPresentationModel.recoveredCount
                val activeCount = viewState.overallPresentationModel.activeCount
                val deathCount = viewState.overallPresentationModel.deathCount

                confirmedTextView.text = confirmedCount.toRoundedString()
                recoveredOverallTextView.text = recoveredCount.toRoundedString()
                activeTextView.text = activeCount.toRoundedString()
                deathTextView.text = deathCount.toRoundedString()

                updateChart(
                    confirmed = confirmedCount,
                    recovered = recoveredCount,
                    deaths = deathCount,
                    active = activeCount
                )
            }
        }
    }

    private fun updateChart(confirmed: Int, recovered: Int, deaths: Int, active: Int) {
        val aaChartModel: AAChartModel = AAChartModel()
            .chartType(AAChartType.Waterfall)
            .animationDuration(5)
            .backgroundColor("#F4F4F4")
            .dataLabelsEnabled(false)
            .yAxisTitle("Cases")
            .legendEnabled(false)
            .categories(arrayOf("Statistics"))
            .xAxisLabelsEnabled(false)
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Confirmed")
                        .data(arrayOf(confirmed))
                        .color("#983434"),
                    AASeriesElement()
                        .name("Recovered")
                        .data(arrayOf(recovered))
                        .color("#1F9A78"),
                    AASeriesElement()
                        .name("Actives")
                        .data(arrayOf(active))
                        .color("#2B5F9E"),
                    AASeriesElement()
                        .name("Deaths")
                        .data(arrayOf(deaths))
                        .color("#505050")
                )
            )
        aaChartView.aa_drawChartWithChartModel(aaChartModel)
    }
}