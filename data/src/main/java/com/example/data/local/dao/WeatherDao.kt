package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.data.local.dto.DayWeatherPojo
import com.example.data.local.dto.HourWeatherPojo
import com.example.data.local.dto.RegionPojo

@Dao
interface WeatherDao {
    @Insert
    fun insertRegion(region: RegionPojo)

    @Insert
    fun insertDayWeather(dayWeather: DayWeatherPojo)

    @Insert
    fun insertHourWeather(hourWeather: HourWeatherPojo)
}