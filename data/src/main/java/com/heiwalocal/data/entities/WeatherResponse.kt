package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("address") val address: String,
    @SerializedName("description") val description: String,
    @SerializedName("days") val days: List<WeatherForTheDayResponse>
)

data class WeatherForTheDayResponse(
    @SerializedName("datetime") val datetime: String,
    @SerializedName("temp") val temp: Double,
    @SerializedName("icon") val icon: String,
    @SerializedName("hours") val hours: List<WeatherForTheHourResponse>,
    @SerializedName("description") val description: String
)

data class WeatherForTheHourResponse(
    @SerializedName("datetime") val datetime: String,
    @SerializedName("temp") val temp: Double,
    @SerializedName("icon") val icon: String,
    @SerializedName("feelslike") val feelsLike: Double,
    @SerializedName("windspeed") val windSpeed: Double,
    @SerializedName("pressure") val pressure: Double,
)
