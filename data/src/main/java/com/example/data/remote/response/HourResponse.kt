package com.example.data.remote.response

import com.google.gson.annotations.SerializedName

data class HourResponse (
    @SerializedName("datetime") val datetime: String,
    @SerializedName("temp") val temp: Double,
    @SerializedName("preciptype") val preciptype: List<String>?
)
