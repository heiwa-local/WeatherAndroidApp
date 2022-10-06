package com.example.data.mapper

import com.example.data.remote.response.DayResponse
import com.example.data.remote.response.HourResponse
import com.example.domain.entity.Day
import com.example.domain.entity.Hour

open class DayResponseMapperService: BaseMapperRepository<DayResponse<HourResponse>, Day<Hour>> {

    private val mapper = HourResponseMapperService()

    override fun transform(type: DayResponse<HourResponse>): Day<Hour> {
        val list: MutableList<Hour> = mutableListOf()
        for (value in type.hours) {
            list.add(value.let { mapper.transform(it) })
        }
        return Day<Hour>(type.datetime, type.tempmax, type.tempmin, type.temp, type.preciptype, type.description, list)
        }

    override fun transformToRepository(type: Day<Hour>): DayResponse<HourResponse> {
        TODO("Not yet implemented")
    }
}