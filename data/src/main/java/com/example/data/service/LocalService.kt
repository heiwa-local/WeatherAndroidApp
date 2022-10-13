package com.example.data.service

import com.example.data.local.database.LocalDatabase
import com.example.data.local.dto.CurrentRegionPojo
import com.example.data.local.dto.DayWeatherPojo
import com.example.data.local.dto.HourWeatherPojo
import com.example.data.local.dto.RegionPojo

class LocalService(
    private val database: LocalDatabase
){

    fun insertRegion(weather: RegionPojo){
        database.weatherDao().insertRegion(weather)
    }

    fun insertDayWeather(dayWeather: DayWeatherPojo){
        database.weatherDao().insertDayWeather(dayWeather)
    }

    fun insertHourWeather(hourWeather: HourWeatherPojo){
        database.weatherDao().insertHourWeather(hourWeather)
    }

    fun getListOfRegionsNames(): List<String?>{
        return database.weatherDao().getListOfRegionsNames()
    }

    fun getDayIdByAddressIdAndDate(regionAddress: String, date: String): Long{
        return database.weatherDao().getDayIdByRegionIdAndDate(regionAddress, date)
    }

    fun getListOfRegions(): List<RegionPojo> {
        return database.weatherDao().getListOfRegions()
    }

    fun getListOfDaysWeatherByRegionId(regionAddress: String): List<DayWeatherPojo> {
        return database.weatherDao().getListOfWeatherForDayByRegionId(regionAddress)
    }

    fun getListOfHoursWeatherByRegionIdAndDate(dayId: Long): List<HourWeatherPojo>{
        return database.weatherDao().getListOfWeatherForHourByRegionIdAndDate(dayId)
    }

    fun getRegionByName(name: String): RegionPojo{
        return database.weatherDao().getRegionByName(name)
    }

    fun clearRegions(){
        database.weatherDao().clearRegions()
    }

    fun clearDays(){
        database.weatherDao().clearDays()
    }

    fun clearHours(){
        database.weatherDao().clearHours()
    }

    fun getUpdateDate(): List<String>{
        return database.weatherDao().getUpdateDate()
    }

    fun insertCurrentRegion(currentRegionPojo: CurrentRegionPojo){
        database.weatherDao().insertCurrentRegion(currentRegionPojo)
    }

    fun getCurrentRegion(): List<CurrentRegionPojo>{
        return database.weatherDao().getCurrentRegion()
    }

    fun clearCurrentRegion(){
        database.weatherDao().clearCurrentRegion()
    }

    fun updateRegions(regions: List<RegionPojo>){
        database.weatherDao().updateRegions(*regions.toTypedArray())
    }

    fun updateDaysWeather(days: List<DayWeatherPojo>){
        database.weatherDao().updateDaysWeather(days)
    }

    fun updateHoursWeather(hours: List<HourWeatherPojo>){
        database.weatherDao().updateHoursWeather(hours)
    }
}