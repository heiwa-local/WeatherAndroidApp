package com.example.data.mapper

import com.example.data.remote.entity.HourResponse
import com.example.domain.entity.Hour

open class HourResponseMapperService: BaseMapperRepository<HourResponse, Hour> {
    override fun transform(type: HourResponse) = Hour (
        type.datetime,
        type.temp,
        type.preciptype
    )

    override fun transformToRepository(type: Hour) = HourResponse (
        type.datetime,
        type.temp,
        type.preciptype
    )
}