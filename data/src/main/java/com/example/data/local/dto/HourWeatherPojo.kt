package com.example.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hour_table")
data class HourWeatherPojo(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val dayId: Long,

    val datetime: String,
    val temp: Double,
    val preciptype: String?

)