package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.local.dto.CurrentRegionPojo
import com.example.data.local.dto.DayWeatherPojo
import com.example.data.local.dto.HourWeatherPojo
import com.example.data.local.dto.RegionPojo

@Dao
interface WeatherDao {
    @Insert
    fun insertRegion(region: RegionPojo)

    @Insert
    fun insertDayWeather(dayWeather: DayWeatherPojo)

    @Insert
    fun insertHourWeather(hourWeather: HourWeatherPojo)

    @Query("SELECT address FROM region_table")
    fun getListOfRegionsNames(): List<String?>

    @Query("SELECT id FROM day_weather WHERE regionAddress = :regionAddress AND datetime = :date")
    fun getDayIdByRegionIdAndDate(regionAddress: String, date: String): Long

    @Query("SELECT * FROM region_table")
    fun getListOfRegions(): List<RegionPojo>

    @Query("SELECT * FROM day_weather WHERE regionAddress = :regionAddress")
    fun getListOfWeatherForDayByRegionId(regionAddress: String): List<DayWeatherPojo>

    @Query("SELECT * FROM hour_table WHERE dayId = :dayId")
    fun getListOfWeatherForHourByRegionIdAndDate(dayId: Long): List<HourWeatherPojo>

    @Query("SELECT * FROM region_table WHERE address = :name")
    fun getRegionByName(name: String): RegionPojo

    @Query("DELETE FROM region_table")
    fun clearRegions()

    @Query("DELETE FROM day_weather")
    fun clearDays()

    @Query("DELETE FROM hour_table")
    fun clearHours()

    @Query("SELECT updateDate FROM region_table")
    fun getUpdateDate(): List<String>

    @Insert
    fun insertCurrentRegion(currentRegion: CurrentRegionPojo)

    @Query("DELETE FROM currentRegion_table")
    fun clearCurrentRegion()

    @Query("SELECT * FROM currentRegion_table")
    fun getCurrentRegion(): List<CurrentRegionPojo>
}