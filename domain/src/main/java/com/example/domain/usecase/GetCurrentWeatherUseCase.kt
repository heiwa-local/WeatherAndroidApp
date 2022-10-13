package com.example.domain.usecase

import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCurrentWeatherUseCase: KoinComponent {
    private val weatherRepository: WeatherRepository by inject()

    operator fun invoke(): Weather<Day<Hour>>{
        return weatherRepository.getCurrentRegionWeather()
    }
}