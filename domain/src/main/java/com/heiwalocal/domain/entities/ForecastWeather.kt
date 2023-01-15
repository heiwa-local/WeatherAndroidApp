package com.heiwalocal.domain.entities

import java.time.LocalDate
import java.time.LocalTime

data class ForecastWeather(
    val hours: List<ForecastWeatherByHours>,
    val days: List<ForecastWeatherByDays>,
    val description: String
)

data class ForecastWeatherByHours(
    val time: LocalTime,
    val temp: Double,
    val icon: String
)

data class ForecastWeatherByDays(
    val date: LocalDate,
    val temp: Double,
    val icon: String
)
