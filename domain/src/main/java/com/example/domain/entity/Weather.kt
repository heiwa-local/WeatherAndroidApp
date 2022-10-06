package com.example.domain.entity


data class Weather<T>(
    val address: String,
    val description: String,
    val days: List<T>
)
