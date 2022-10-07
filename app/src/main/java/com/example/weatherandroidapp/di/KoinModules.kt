package com.example.weatherandroidapp.di

import com.example.domain.usecase.GetWeatherForWeekByRegionUseCase
import com.example.domain.usecase.SaveWeatherToLocalDatabaseUseCase
import com.example.weatherandroidapp.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MainViewModel(get(), get()) }
}

//val

val useCasesModule = module {
    single { GetWeatherForWeekByRegionUseCase() }
    single { SaveWeatherToLocalDatabaseUseCase() }
}