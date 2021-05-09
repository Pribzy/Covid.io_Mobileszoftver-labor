package hu.bme.aut.pribelszki.covidio.di

import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
val Injector: TestComponent
    get() {
        return DaggerTestComponent.builder().build()
    }