package com.heiwalocal.data.repositories

import com.heiwalocal.data.entities.WeatherResponse
import com.heiwalocal.data.mappers.WeatherMapperService
import com.heiwalocal.data.remote.weatherApi.WeatherApiService
import com.heiwalocal.domain.entities.Weather
import com.heiwalocal.domain.repository.WeatherRepository
import com.heiwalocal.domain.utilities.Response
import com.heiwalocal.domain.utilities.ResponseStatus

class WeatherRepositoryImpl(): WeatherRepository {

    private val weatherApiService = WeatherApiService()

    private val mapper = WeatherMapperService()

    override fun getWeatherForecastForTheRegion(region: String): Response<Weather> {

        val response = weatherApiService.getWeatherForecastForTheRegion(region = region)

        if (response != null) {
            return try {
                Response(
                    status = ResponseStatus.SUCCESS,
                    data = response.let { mapper.transform(it) }
                )
            } catch (e: Exception) {
                Response(
                    status = ResponseStatus.PARSE_ERROR,
                    data = null
                )
            }
        }
        return Response(
            status = ResponseStatus.FAILURE,
            data = null
        )
    }
}

fun WeatherResponse.completenessCheck(): Boolean {
    if (days.size == 10) {
        days.map { day ->
            if (day.hours.size != 24) {
                return false
            }
        }
        return true
    }
    return false
}