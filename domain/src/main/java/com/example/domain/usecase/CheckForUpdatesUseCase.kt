package com.example.domain.usecase

import com.example.domain.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CheckForUpdatesUseCase: KoinComponent {

    private val weatherRepository: WeatherRepository by inject()

    operator fun invoke(){
        val currentDate = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        val dateFrom = currentDate.format(formatter).toString()
        val currentDatePlusWeek = currentDate.plusDays(7)
        val dateTo = currentDatePlusWeek.format(formatter).toString()


    }
}