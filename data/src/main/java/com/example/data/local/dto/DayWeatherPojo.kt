package com.example.data.local.dto

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_weather")
data class DayWeatherPojo(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val regionAddress: String,

    val datetime: String,
    val tempmax: Double,
    val tempmin: Double,
    val temp: Double,
    val icon: String,
    val description: String
)