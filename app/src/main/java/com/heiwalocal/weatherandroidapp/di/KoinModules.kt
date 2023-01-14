package com.heiwalocal.weatherandroidapp.di

import com.heiwalocal.domain.useCases.GetWeatherForecastForTheRegionUseCase
import com.heiwalocal.weatherandroidapp.screens.detail.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { DetailScreenViewModel(get()) }
}

val useCasesModule = module {
    single { GetWeatherForecastForTheRegionUseCase() }
}