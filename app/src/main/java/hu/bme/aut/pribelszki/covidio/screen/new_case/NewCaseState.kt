package hu.bme.aut.pribelszki.covidio.screen.new_case

import hu.bme.aut.pribelszki.covidio.network.model.NewCase

sealed class NewCaseViewState

object Initial : NewCaseViewState()

data class CaseUploaded(val createdCase: NewCase?): NewCaseViewState()

object Loading: NewCaseViewState()

object NetworkError: NewCaseViewState()