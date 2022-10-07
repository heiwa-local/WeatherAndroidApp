package com.example.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.WeatherDao
import com.example.data.local.dto.DayWeatherPojo
import com.example.data.local.dto.HourWeatherPojo
import com.example.data.local.dto.RegionPojo

@Database(entities = [RegionPojo::class, DayWeatherPojo::class, HourWeatherPojo::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object{
        fun create(context: Context): LocalDatabase {
            return Room.databaseBuilder(
                context,
                LocalDatabase::class.java, "WEATHER_DATABASE"
            ).fallbackToDestructiveMigration().build()
        }
    }

}