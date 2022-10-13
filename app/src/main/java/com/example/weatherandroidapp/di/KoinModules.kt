package com.example.weatherandroidapp.di

import com.example.domain.usecase.*
import com.example.weatherandroidapp.screen.current.viewmodel.CurrentViewModel
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.screen.home.viewmodel.RegionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { RegionsViewModel(get(), get(), get()) }
    viewModel { DetailViewModel(get(), get(), get(), get()) }
    viewModel { CurrentViewModel(get(), get(), get())}
}

val useCasesModule = module {
    single { GetWeatherForWeekByRegionUseCase() }
    single { SaveWeatherToLocalDatabaseUseCase() }
    single { UpdateLocalDatabaseUseCase() }
    single { GetListOfRegionsWithWeatherFromLocalDatabaseUseCase() }
    single { GetCurrentWeatherUseCase() }
    single { InsertCurrentRegionUseCase() }
}