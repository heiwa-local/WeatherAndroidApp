package com.example.data.local.dto

import androidx.room.Embedded
import androidx.room.Relation

data class WeatherForDay(
    @Embedded val day: DayWeatherPojo,
    @Relation(
        parentColumn = "id",
        entityColumn = "dayId"
    )
    val hour: List<HourWeatherPojo>
)
