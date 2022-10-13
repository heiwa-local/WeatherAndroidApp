package com.example.domain.usecase

import com.example.domain.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SaveWeatherToLocalDatabaseUseCase: KoinComponent {

    private val weatherRepository: WeatherRepository by inject()

    operator fun invoke() =
        weatherRepository.insertFromRemoteToLocalDatabase(listOfRegions =  listOf("Moscow","London","New-york", "Detroit"), dateFrom = "2022-10-10", dateTo = "2022-10-17")
}