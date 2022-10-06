package com.example.di

import com.example.data.service.RemoteService
import com.example.data.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single { RemoteService() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}