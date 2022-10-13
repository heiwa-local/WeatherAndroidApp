package com.example.domain.entity

data class Day<T>(
    val datetime: String,
    val tempmax: Double,
    val tempmin: Double,
    val temp: Double,
    val icon: String,
    val description: String,
    val hours: List<T>
)
