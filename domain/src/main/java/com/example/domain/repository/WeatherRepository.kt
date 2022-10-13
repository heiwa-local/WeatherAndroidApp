package com.example.domain.repository

import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.utility.Response

interface WeatherRepository {

    fun getListOfRegionsNames(): List<String?>

    fun insertFromRemoteToLocalDatabase(listOfRegions: List<String?>, dateFrom: String, dateTo: String): Boolean

    fun getListOfRegionsWithWeatherFromLocalDatabase(): List<Weather<Day<Int>>>

    fun getRegionWeatherFromLocalDB(region: String): Weather<Day<Hour>>

    fun clearLocalDB(): Boolean

    fun checkForUpdate(dateFrom: String): Boolean

    fun insertCurrentRegion(regionName: String)

    fun getCurrentRegionWeather(): Weather<Day<Hour>>
}