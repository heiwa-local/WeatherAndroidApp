package com.heiwalocal.data.repositories

import com.heiwalocal.domain.utilities.ResponseStatus
import org.junit.Test
import org.junit.Assert.*

internal class WeatherRepositoryImplTest {

    private val weatherRepositoryImpl = WeatherRepositoryImpl()

    @Test
    fun getWeatherForecastForTheRegion() {
        val response = weatherRepositoryImpl.getWeatherForecastForTheRegion("Moscow")
        when (response.status) {
            ResponseStatus.SUCCESS -> assertNotEquals(null, response.data)
            ResponseStatus.FAILURE -> assertEquals(null, response.data)
            ResponseStatus.PARSE_ERROR -> assertEquals(null, response.data)
        }
    }
}