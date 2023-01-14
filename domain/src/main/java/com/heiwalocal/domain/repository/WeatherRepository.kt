package com.heiwalocal.domain.repository

import com.heiwalocal.domain.entities.Weather
import com.heiwalocal.domain.utilities.Response

interface WeatherRepository {

    fun getWeatherForecastForTheRegion(region: String): Response<Weather>
}