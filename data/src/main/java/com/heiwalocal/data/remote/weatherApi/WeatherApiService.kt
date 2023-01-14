package com.heiwalocal.data.remote.weatherApi

import com.heiwalocal.data.entities.WeatherResponse

class WeatherApiService {
    private val api = WeatherApiInterface
        .getInstance()
        .create(WeatherApiInterface::class.java)

    fun getWeatherForecastForTheRegion(region: String): WeatherResponse? {
        val call = api.getWeatherForecastForTheRegion(
            region = region,
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }
}