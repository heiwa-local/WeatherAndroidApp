package com.example.data.di

import androidx.room.Room
import com.example.data.local.database.LocalDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

//val databaseModule = module {
//    single { Room
//        .databaseBuilder(androidApplication(),
//            LocalDatabase::class.java, "WEATHER_DATABASE"
//        ).fallbackToDestructiveMigration().build() }
//
//    single {
//        get<LocalDatabase>().weatherDao()
//    }
//}