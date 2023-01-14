package com.heiwalocal.domain.useCases

import android.util.Log
import com.heiwalocal.domain.entities.Weather
import com.heiwalocal.domain.repository.WeatherRepository
import com.heiwalocal.domain.utilities.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetWeatherForecastForTheRegionUseCase(): KoinComponent {
    private val repository: WeatherRepository by inject()

    operator fun invoke(region: String): Response<Weather> = run {
        return repository.getWeatherForecastForTheRegion(region = region)
    }
}