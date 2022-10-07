package com.example.data.remote.entity

import com.google.gson.annotations.SerializedName

data class DayResponse<T>(
    @SerializedName("datetime") val datetime: String,
    @SerializedName("tempmax") val tempmax: Double,
    @SerializedName("tempmin") val tempmin: Double,
    @SerializedName("temp") val temp: Double,
    @SerializedName("preciptype") val preciptype: List<String>?,
    @SerializedName("description") val description: String,
    @SerializedName("hours") val hours: List<T>
)
