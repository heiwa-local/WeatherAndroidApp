package com.heiwalocal.di

import com.heiwalocal.data.repositories.WeatherRepositoryImpl
import com.heiwalocal.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl() }
}