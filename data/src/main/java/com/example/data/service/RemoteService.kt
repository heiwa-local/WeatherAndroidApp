package com.example.data.service

import com.example.data.mapper.WeatherResponseMapperService
import com.example.data.remote.api.ApiInterface
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.utility.Response

class RemoteService {
    private val api = ApiInterface.getInstance()
    private val mapper: WeatherResponseMapperService = WeatherResponseMapperService()

    fun getWeatherForRegion(region: String, dateFrom: String, dateTo: String):Response<Weather<Day<Hour>>> {
        val call = api.create(ApiInterface::class.java).getWeatherForRegion(region = region,dateFrom = dateFrom, dateTo = dateTo)
        val response = call.execute()

        if (response.body() != null){
            if (response.isSuccessful){
                response.body()?.let { mapper.transform(it) }.let { return Response("success",it) }
            }
            return Response(response.message(), null)
        }
        return Response("bad request", null)
    }
}