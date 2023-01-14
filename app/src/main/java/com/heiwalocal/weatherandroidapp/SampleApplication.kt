package com.heiwalocal.weatherandroidapp

import android.app.Application
import com.heiwalocal.di.repositoriesModule
import com.heiwalocal.weatherandroidapp.di.useCasesModule
import com.heiwalocal.weatherandroidapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SampleApplication)
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}