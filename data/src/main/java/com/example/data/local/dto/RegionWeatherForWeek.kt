package com.example.data.local.dto

import androidx.room.Embedded
import androidx.room.Relation

data class RegionWeatherForWeek(
    @Embedded val region: RegionPojo,
    @Relation(
        parentColumn = "id",
        entityColumn = "regionId"
    )
    val day: List<WeatherForDay>
)
