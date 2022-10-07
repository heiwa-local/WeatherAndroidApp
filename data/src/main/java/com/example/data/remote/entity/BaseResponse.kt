package com.example.data.remote.entity

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("address") val address: String,
    @SerializedName("description") val description: String,
    @SerializedName("days") val days: List<T>
)
