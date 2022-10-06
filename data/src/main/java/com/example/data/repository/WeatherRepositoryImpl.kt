package com.example.data.repository

import com.example.data.service.RemoteService
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.repository.WeatherRepository
import com.example.domain.utility.Response

class WeatherRepositoryImpl(
    private val remoteService: RemoteService
): WeatherRepository {
    override fun getWeaterForRegion(region: String, dateFrom: String, dateTo: String): Response<Weather<Day<Hour>>> {
        return remoteService.getWeatherForRegion(region = region, dateFrom = dateFrom, dateTo = dateTo)
    }
}