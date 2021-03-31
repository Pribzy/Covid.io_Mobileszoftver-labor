package hu.bme.aut.pribelszki.covidio.domain.model

data class CaseCounts(val totalCount: Int,
                      val yesterdayCount: Int,
                      val lastThreeMonthCount: Int)
