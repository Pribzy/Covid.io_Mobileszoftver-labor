package hu.bme.aut.pribelszki.covidio.screen.new_case

sealed class NewCaseViewState

object Initial : NewCaseViewState()

object Loading : NewCaseViewState()

object CaseUploaded : NewCaseViewState()

object NetworkError: NewCaseViewState()