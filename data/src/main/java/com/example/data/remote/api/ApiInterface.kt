package com.example.data.remote.api

import com.example.data.remote.response.DayResponse
import com.example.data.remote.response.HourResponse
import com.example.data.remote.response.BaseResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("timeline/{region}/{dateFrom}/{dateTo}?unitGroup=metric&key=BHJQNUJAMSADETUULNK2GD7D7&contentType=json")
    fun getWeatherForRegion(@Path("region") region: String,
                             @Path("dateFrom") dateFrom: String,
                             @Path("dateTo") dateTo: String): Call<BaseResponse<DayResponse<HourResponse>>>

    companion object ApiUtilities {
        var BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}