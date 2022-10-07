package com.example.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_weather")
data class DayWeatherPojo(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val regionId: Long,

    val datetime: String,
    val tempmax: Double,
    val tempmin: Double,
    val temp: Double,
    val preciptype: String?,
    val description: String
)