package com.example.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currentRegion_table")
data class CurrentRegionPojo(
    @PrimaryKey
    val currentRegionName: String,
)