package com.example.domain.usecase

import com.example.domain.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InsertCurrentRegionUseCase: KoinComponent {
    private val weatherRepository: WeatherRepository by inject()

    operator fun invoke(regionName: String){
        weatherRepository.insertCurrentRegion(regionName)

        val currentDate = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        val dateFrom = currentDate.format(formatter).toString()
        val currentDatePlusWeek = currentDate.plusDays(6)
        val dateTo = currentDatePlusWeek.format(formatter).toString()


        val listOfRegions = weatherRepository.getListOfRegionsNames()

        val exist = listOfRegions.find { it == regionName }

        if (exist == null){
            weatherRepository.insertFromRemoteToLocalDatabase(
                listOfRegions =  listOf(regionName),
                dateFrom = dateFrom,
                dateTo = dateTo
            )
        }
    }
}