package com.example.weatherandroidapp.di

import com.example.domain.usecase.GetWeatherForWeekByRegionUseCase
import com.example.weatherandroidapp.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel(get()) }
}

val useCasesModule = module {
    single { GetWeatherForWeekByRegionUseCase() }
}