package com.example.weatherandroidapp

import android.app.Application
import com.example.di.repositoriesModule
import com.example.weatherandroidapp.di.useCasesModule
import com.example.weatherandroidapp.di.viewModelsModule
import org.koin.core.context.GlobalContext.startKoin

class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}