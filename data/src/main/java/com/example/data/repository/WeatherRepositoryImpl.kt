package com.example.data.repository

import android.content.Context
import com.example.data.local.database.LocalDatabase
import com.example.data.local.dto.RegionPojo
import com.example.data.service.LocalService
import com.example.data.service.RemoteService
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.repository.WeatherRepository
import com.example.domain.utility.Response

class WeatherRepositoryImpl(
    private val remoteService: RemoteService,
    private val localService: LocalService
): WeatherRepository {


    override fun getWeatherForRegion(region: String, dateFrom: String, dateTo: String): Response<Weather<Day<Hour>>> {
        return remoteService.getWeatherForRegion(region = region, dateFrom = dateFrom, dateTo = dateTo)
    }

    override fun insertWeather() {
        localService.insertRegion()
    }
}