package hu.bme.aut.pribelszki.covidio.screen.country.details.confirmed

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.google.firebase.analytics.FirebaseAnalytics
import hu.bme.aut.pribelszki.covidio.R
import hu.bme.aut.pribelszki.covidio.screen.country.details.model.Case
import hu.bme.aut.pribelszki.covidio.screen.new_case.NewCaseActivity
import hu.bme.aut.pribelszki.covidio.util.DECIMAL_FORMAT
import hu.bme.aut.pribelszki.covidio.util.formatValue
import kotlinx.android.synthetic.main.fragment_country_details_confirmed.*
import kotlinx.android.synthetic.main.fragment_country_list.loadingAnimation


class CountryDetailsConfirmedFragment :
    RainbowCakeFragment<CountryDetailsConfirmedState, CountryDetailsConfirmedViewModel>() {
    private var analytics: FirebaseAnalytics? = null
    private lateinit var aaChartView: AAChartView

    override fun getViewResource() = R.layout.fragment_country_details_confirmed

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aaChartView = requireActivity().findViewById(R.id.confirmedChartView)
        analytics = FirebaseAnalytics.getInstance(activity)
        val countryId = activity?.intent?.getStringExtra("countryId")
        if (countryId != null) {
            viewModel.loadStatus(countryId)
        }
        confirmedNewCaseButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "button_tap")
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "country_details_fragment")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "action")
            analytics!!.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
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
        val aaChartModel = AAChartModel()
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
                        .data(cases.map { it.count }.toTypedArray())
                        .color("#983434")
                )
            )
        aaChartView.aa_drawChartWithChartModel(aaChartModel)
    }
}