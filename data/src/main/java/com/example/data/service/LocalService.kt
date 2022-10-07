package com.example.data.service

import android.content.Context
import androidx.room.Room
import com.example.data.local.database.LocalDatabase
import com.example.data.local.dto.RegionPojo
import kotlin.coroutines.coroutineContext

class LocalService(
    private val database: LocalDatabase
){

    fun insertRegion(){
        database.weatherDao().insertRegion(RegionPojo(0,"Moscow","123"))
    }
}