package com.example.domain.usecase

import android.util.Log
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.repository.WeatherRepository
import com.example.domain.utility.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetWeatherForWeekByRegionUseCase: KoinComponent {

    private val weatherRepository: WeatherRepository by inject()

    init {
        Log.e("AAA", "GetWeatherByRegionAndDateUseCase created")
    }
//    private val repository: WeatherRepository = WeatherRepository
    operator fun invoke(
        region: String,
        dateFrom: String,
        dateTo: String
        ): Response<Weather<Day<Hour>>> =
            weatherRepository.getWeatherForRegion(
                region = region,
                dateFrom = dateFrom,
                dateTo = dateTo
            )
}