package com.example.domain.entity

data class Hour(
    val datetime: String,
    val temp: Double,
    val preciptype: List<String>?

)
