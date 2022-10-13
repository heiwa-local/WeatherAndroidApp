package com.example.weatherandroidapp.di

import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import com.example.domain.usecase.*
import com.example.weatherandroidapp.screen.current.viewmodel.CurrentViewModel
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.screen.home.viewmodel.HomeViewModel
import com.example.weatherandroidapp.screen.settings.SettingsScreen
import com.example.weatherandroidapp.screen.settings.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel(get(), get(), get(), get()) }
    viewModel { DetailViewModel(get(), get(), get(), get()) }
    viewModel { CurrentViewModel(get(), get(), get())}
    viewModel { SettingsViewModel(get(), get()) }
}

//val

val useCasesModule = module {
    single { GetWeatherForWeekByRegionUseCase() }
    single { SaveWeatherToLocalDatabaseUseCase() }
    single { UpdateLocalDatabaseUseCase() }
    single { GetListOfRegionsWithWeatherFromLocalDatabaseUseCase() }
    single { CheckForUpdatesUseCase() }
    single { GetCurrentWeatherUseCase() }
    single { InsertCurrentRegionUseCase() }
}