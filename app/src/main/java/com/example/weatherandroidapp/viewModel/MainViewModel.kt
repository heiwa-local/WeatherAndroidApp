package com.example.weatherandroidapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.usecase.GetWeatherForWeekByRegionUseCase
import com.example.domain.utility.Response
import com.example.weatherandroidapp.viewModel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val getWeatherForWeekByRegionUseCase: GetWeatherForWeekByRegionUseCase): BaseViewModel() {
    init {
        Log.e("HEIWA", "MainViewModel created")
    }

    private val mutableStatusLD: MutableLiveData<Response<Weather<Day<Hour>>>> = MutableLiveData()
    val statusLD: LiveData<Response<Weather<Day<Hour>>>>
        get() { return mutableStatusLD }


    fun getStatus() = launch(Dispatchers.IO) {
        Log.e("HEIWA", "MainViewModel getStatus method started")
        mutableStatusLD.postValue(getWeatherForWeekByRegionUseCase.invoke("Moscow", "2022-10-06", "2022-10-10"))
    }
}