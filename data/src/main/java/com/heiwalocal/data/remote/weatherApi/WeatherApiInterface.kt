package com.heiwalocal.data.remote.weatherApi

import com.heiwalocal.data.entities.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val apiKey = "BHJQNUJAMSADETUULNK2GD7D7"

interface WeatherApiInterface {

    @GET("{region}?unitGroup=metric&key=$apiKey&contentType=json")
    fun getWeatherForecastForTheRegion(@Path("region") region: String): Call<WeatherResponse>

    companion object ApiUtilities {
        var BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}