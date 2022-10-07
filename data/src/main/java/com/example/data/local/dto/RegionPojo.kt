package com.example.data.local.dto

import androidx.room.*

@Entity(tableName = "region_table")
data class RegionPojo(
    @PrimaryKey(autoGenerate = true) val id: Long,

    val address: String,
    val description: String,
)
