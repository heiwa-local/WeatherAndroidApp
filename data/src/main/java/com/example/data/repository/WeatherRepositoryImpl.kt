package com.example.data.repository

import android.util.Log
import com.example.data.local.dto.CurrentRegionPojo
import com.example.data.local.dto.DayWeatherPojo
import com.example.data.local.dto.HourWeatherPojo
import com.example.data.local.dto.RegionPojo
import com.example.data.service.LocalService
import com.example.data.service.RemoteService
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.repository.WeatherRepository
import com.example.domain.utility.Response

class WeatherRepositoryImpl(
    private val remoteService: RemoteService,
    private val localService: LocalService
): WeatherRepository {


    override fun getWeatherForRegion(region: String, dateFrom: String, dateTo: String): Response<Weather<Day<Hour>>> {
        return remoteService.getWeatherForRegion(region = region, dateFrom = dateFrom, dateTo = dateTo)
    }

    override fun insertWeather() {
//        localService.insertRegion()
    }

    override fun getListOfRegionsNames(): List<String?> {
        return localService.getListOfRegionsNames()
    }

    override fun insertFromRemoteToLocalDatabase(
        listOfRegions: List<String?>,
        dateFrom: String,
        dateTo: String
    ): Boolean {
        Log.e("HEIWA", listOfRegions.toString())

        val listFromLocal = localService.getListOfRegionsNames()

        try {
            for (region in listOfRegions) {
                val isInDB = listFromLocal.find { it == region }
                if (region != null && isInDB == null) {
                    val weather = remoteService.getWeatherForRegion(
                        region = region,
                        dateFrom = dateFrom,
                        dateTo = dateTo
                    ).data
                    Log.e("HEIWA", weather.toString())
                    if (weather != null) {
                        localService.insertRegion(
                            RegionPojo(
                                address = weather.address,
                                description = weather.description,
                                updateDate = dateFrom
                            )
                        )
                        for (day in weather.days) {
                            val date = day.datetime
                            localService.insertDayWeather(
                                DayWeatherPojo(
                                    id = 0,
                                    regionAddress = weather.address,
                                    datetime = date,
                                    tempmax = day.tempmax,
                                    tempmin = day.tempmin,
                                    temp = day.temp,
                                    icon = day.icon,
                                    description = day.description
                                )
                            )
                            for (hour in day.hours) {
                                val dayId = localService.getDayIdByAddressIdAndDate(
                                    regionAddress = region,
                                    date = date
                                )
                                localService.insertHourWeather(
                                    HourWeatherPojo(
                                        id = 0,
                                        dayId = dayId,
                                        datetime = hour.datetime,
                                        temp = hour.temp,
                                        icon = hour.icon
                                    )
                                )
                            }
                        }
                    }
                }
            }
        } catch (e: Exception){
            Log.e("HEIWA", "ERROR IN INSERT")
            return false
        }
        return true
    }

    override fun getListOfRegionsWithWeatherFromLocalDatabase(): List<Weather<Day<Int>>> {
        val list: MutableList<Weather<Day<Int>>> = mutableListOf()
        var listOfDaysWeather: MutableList<Day<Int>> = mutableListOf()

        val listFromOfRegionsFromLocalDB = localService.getListOfRegions()

        for (region in listFromOfRegionsFromLocalDB){
            val days = localService.getListOfDaysWeatherByRegionId(region.address)
            for (day in days){
                listOfDaysWeather.add(Day<Int>(
                    datetime = day.datetime,
                    tempmax = day.tempmax,
                    tempmin = day.tempmin,
                    temp = day.temp,
                    icon = day.icon,
                    description = day.description,
                    hours = listOf(0)
                ))
            }
            list.add(Weather<Day<Int>>(
                address = region.address,
                description = region.description,
                days = listOfDaysWeather
            )
            )
            listOfDaysWeather = mutableListOf()
        }
        return list
    }

    override fun getRegionWeatherFromLocalDB(regionName: String): Weather<Day<Hour>> {
        val region = localService.getRegionByName(regionName)

        val days = localService.getListOfDaysWeatherByRegionId(regionName)

        val daysList: MutableList<Day<Hour>> = mutableListOf()
        var hoursList: MutableList<Hour> = mutableListOf()
        for (day in days){

            val dayId = localService.getDayIdByAddressIdAndDate(regionName, days.get(0).datetime)
            val hours = localService.getListOfHoursWeatherByRegionIdAndDate(dayId)
            for (hour in hours){
                hoursList.add(
                    Hour(
                        datetime = hour.datetime,
                        temp = hour.temp,
                        icon = hour.icon
                    )
                )
            }
            daysList.add(Day<Hour>(
                datetime = day.datetime,
                tempmax =  day.tempmax,
                tempmin = day.tempmin,
                temp = day.temp,
                icon = day.icon,
                description = day.description,
                hours = hoursList
            ))
            hoursList = mutableListOf()
        }
        Log.e("Repository", daysList.toString())
        return Weather(
            address = region.address,
            description = region.description,
            days = daysList)
    }

    override fun clearLocalDB(): Boolean {

        try {
            localService.clearRegions()
            localService.clearDays()
            localService.clearHours()
        } catch (e: Exception){
            return false
        }
        return true
    }

    override fun checkForUpdate(dateFrom: String): Boolean {
        val updateDate = localService.getUpdateDate()

        for (date in updateDate){
            if (date != dateFrom){
                return true
            }
        }
        return false

    }

    override fun insertCurrentRegion(regionName: String) {

        localService.clearCurrentRegion()

        localService.insertCurrentRegion(
            CurrentRegionPojo(
                regionName
            )
        )
    }

    override fun getCurrentRegionWeather(): Weather<Day<Hour>> {
        val currentRegionPojo = localService.getCurrentRegion()[0]
        val region = localService.getRegionByName(currentRegionPojo.currentRegionName)

        val days: MutableList<Day<Hour>> = mutableListOf()
        var hours: MutableList<Hour> = mutableListOf()

        for (day in localService.getListOfDaysWeatherByRegionId(region.address)) {

            for (hour in localService.getListOfHoursWeatherByRegionIdAndDate(day.id)) {
                hours.add(
                    Hour(
                        datetime = hour.datetime,
                        temp = hour.temp,
                        icon = hour.icon
                    )
                )
            }
            days.add(
                Day(
                    datetime = day.datetime,
                    tempmax = day.tempmax,
                    tempmin = day.tempmin,
                    temp = day.temp,
                    icon = day.icon,
                    description = day.description,
                    hours = hours
                )
            )
            hours = mutableListOf()
        }
        return Weather(
            address = region.address,
            description = region.description,
            days = days
        )
    }

}