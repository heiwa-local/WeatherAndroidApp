package com.example.domain.entity

data class Day<T>(
    val datetime: String,
    val tempmax: Double,
    val tempmin: Double,
    val temp: Double,
    val preciptype: List<String>?,
    val description: String,
    val hours: List<T>
)
