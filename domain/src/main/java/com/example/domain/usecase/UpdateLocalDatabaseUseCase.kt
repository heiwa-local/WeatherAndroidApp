package com.example.domain.usecase

import android.util.Log
import com.example.domain.repository.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UpdateLocalDatabaseUseCase: KoinComponent {
    private val weatherRepository: WeatherRepository by inject()

    operator fun invoke() = run {
        val currentDate = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        val dateFrom = currentDate.format(formatter).toString()
        val currentDatePlusWeek = currentDate.plusDays(6)
        val dateTo = currentDatePlusWeek.format(formatter).toString()

        val needToUpdate = weatherRepository.checkForUpdate(dateFrom)

        if (needToUpdate) {
            Log.e("HEIWA", "NEED TO UPDATE")

            val listOfRegionNames = weatherRepository.getListOfRegionsNames()

            if (weatherRepository.clearLocalDB()){
                if(weatherRepository.insertFromRemoteToLocalDatabase(
                    listOfRegions = listOfRegionNames,
                    dateFrom = dateFrom,
                    dateTo = dateTo
                )){
                    Log.e("HEIWA", "DATA INSERT TO DB")
                }
                Log.e("HEIWA", "DB CLEARED")
            }

            Log.e("HEIWA", "UPDATED NOW $listOfRegionNames")
        }
        Log.e("HEIWA", "UPDATED")
    }
}