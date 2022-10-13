package com.example.data.local.dto

import androidx.room.*

@Entity(tableName = "region_table")
data class RegionPojo(
    @PrimaryKey val address: String,
    val description: String,
    val updateDate: String
)
