package com.example.weatherandroidapp.screen.detail.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.domain.usecase.GetWeatherForWeekByRegionUseCase
import com.example.domain.usecase.InsertCurrentRegionUseCase
import com.example.domain.usecase.UpdateLocalDatabaseUseCase
import com.example.domain.utility.Response
import com.example.weatherandroidapp.viewModel.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getWeatherForWeekByRegionUseCase: GetWeatherForWeekByRegionUseCase,
    private val updateLocalDatabaseUseCase: UpdateLocalDatabaseUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val insertCurrentRegionUseCase: InsertCurrentRegionUseCase
): BaseViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }



    private val mutableSelectedRegionLd: MutableLiveData<String> = MutableLiveData()
    val selectedRegionLD: LiveData<String>
        get() { return mutableSelectedRegionLd }

    fun setCurrentRegion(region: String) {
        mutableSelectedRegionLd.postValue(region)
    }



    private val mutableWeatherForWeekByRegionListLD: MutableLiveData<Weather<Day<Hour>>> = MutableLiveData()
    val regionWeatherForWeekLD: LiveData<Weather<Day<Hour>>>
        get() {return mutableWeatherForWeekByRegionListLD}
    fun getOfWeatherForWeekByRegion(regionName: String) = launch(Dispatchers.IO + coroutineExceptionHandler) {
        mutableWeatherForWeekByRegionListLD.postValue(getWeatherForWeekByRegionUseCase.invoke(regionName))
    }

    fun insertCurrentRegion(regionName: String) = launch(Dispatchers.IO + coroutineExceptionHandler){
        insertCurrentRegionUseCase.invoke(regionName)
    }



    fun updateLocalDatabase() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        updateLocalDatabaseUseCase.invoke()
    }
}