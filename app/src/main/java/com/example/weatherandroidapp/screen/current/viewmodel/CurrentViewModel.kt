package com.example.weatherandroidapp.screen.current.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.usecase.GetCurrentWeatherUseCase
import com.example.domain.usecase.InsertCurrentRegionUseCase
import com.example.domain.usecase.UpdateLocalDatabaseUseCase
import com.example.weatherandroidapp.viewModel.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val insertCurrentRegionUseCase: InsertCurrentRegionUseCase,
    private val updateLocalDatabaseUseCase: UpdateLocalDatabaseUseCase
): BaseViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val mutableCurrentRegionLd: MutableLiveData<Weather<Day<Hour>>> = MutableLiveData()
    val currentRegionLD: LiveData<Weather<Day<Hour>>>
        get() { return mutableCurrentRegionLd }

    fun getCurrentWeather() = launch(Dispatchers.IO + coroutineExceptionHandler){
        mutableCurrentRegionLd.postValue(getCurrentWeatherUseCase.invoke())
    }

    fun updateLocalDatabase() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        updateLocalDatabaseUseCase.invoke()
    }

}