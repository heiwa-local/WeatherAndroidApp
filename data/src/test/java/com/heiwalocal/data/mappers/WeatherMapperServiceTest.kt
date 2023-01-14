package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.WeatherForTheDayResponse
import com.heiwalocal.data.entities.WeatherForTheHourResponse
import com.heiwalocal.data.entities.WeatherResponse

import org.junit.Test

import org.junit.Assert.*

internal class WeatherMapperServiceTest {

    private val weatherMapperService = WeatherMapperService()

    private val mockWeatherResponse = WeatherResponse(
        address = "Moscow",
        description = "asdsad",
        days = listOf(
            WeatherForTheDayResponse(
                datetime = "2023-01-22",
                temp = -12.0,
                icon = "cloudy",
                hours = listOf(
                    WeatherForTheHourResponse(
                        datetime = "12:00:00",
                        temp = -9.0,
                        icon = "clear",
                        feelsLike = 2.0,
                        windSpeed = 20.0,
                        pressure = 1000.0
                    )
                )
            )
        )
    )

//    @Test
//    fun transform() {
//        assertEquals(true, mockWeatherResponse.let { weatherMapperService.transform(it) })
//    }
}