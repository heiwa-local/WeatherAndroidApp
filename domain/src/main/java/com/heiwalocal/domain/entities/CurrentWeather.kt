package com.heiwalocal.domain.entities

import java.time.LocalDate

data class CurrentWeather(
    val datetime: LocalDate,
    val temp: Double,
    val icon: String,
    val feelsLike: Double,
    val windSpeed: Double,
    val pressure: Double,
)