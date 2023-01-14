package com.heiwalocal.data.remote.weatherApi

import org.junit.Test

import org.junit.Assert.*


internal class WeatherApiServiceTest {
    private val weatherApiService = WeatherApiService()

    @Test
    fun getWeatherForecastForTheRegion(){
        assertEquals(null, weatherApiService.getWeatherForecastForTheRegion("MoscowW"))
        assertNotEquals(null ,weatherApiService.getWeatherForecastForTheRegion("Moscow"))
    }
}