package com.example.domain.repository

import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.utility.Response

interface WeatherRepository {

    fun getWeatherForRegion(region: String, dateFrom: String, dateTo: String): Response<Weather<Day<Hour>>>

    fun insertWeather()
}