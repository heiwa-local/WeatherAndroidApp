package com.example.data.remote.entity

import com.google.gson.annotations.SerializedName

data class HourResponse (
    @SerializedName("datetime") val datetime: String,
    @SerializedName("temp") val temp: Double,
    @SerializedName("icon") val icon: String
)
