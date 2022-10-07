package com.example.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.database.LocalDatabase
import com.example.data.service.RemoteService
import com.example.data.repository.WeatherRepositoryImpl
import com.example.data.service.LocalService
import com.example.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoriesModule = module {

    single { RemoteService() }
    single { LocalService( LocalDatabase.create(androidContext()) ) }

    single<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
}
