package com.example.data.mapper

import com.example.data.remote.entity.BaseResponse
import com.example.data.remote.entity.DayResponse
import com.example.data.remote.entity.HourResponse
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather

open class WeatherResponseMapperService: BaseMapperRepository<BaseResponse<DayResponse<HourResponse>>, Weather<Day<Hour>>> {

    private val hourMapper = HourResponseMapperService()

    //    override fun transformTorepository(type: Weather) = WeatherResponse (
//        type.address,
//        type.description,
//        type.days
//    )
    override fun transform(type: BaseResponse<DayResponse<HourResponse>>): Weather<Day<Hour>> {
        val dayList: MutableList<Day<Hour>> = mutableListOf()
        var hourList: MutableList<Hour> = mutableListOf()
        for (i in type.days) {
            for (j in i.hours) {
                hourList.add(j.let { hourMapper.transform(it)})
            }
            dayList.add(Day(i.datetime,i.tempmax,i.tempmin,i.temp,i.preciptype,i.description, hourList))
            hourList = mutableListOf()
        }
        return Weather(type.address,type.description,dayList)
    }

    override fun transformToRepository(type: Weather<Day<Hour>>): BaseResponse<DayResponse<HourResponse>> {
        TODO("Not yet implemented")
    }

}