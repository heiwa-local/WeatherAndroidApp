package com.example.weatherandroidapp.screen.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.Day
import com.example.domain.entity.Weather
import com.example.domain.usecase.GetListOfRegionsWithWeatherFromLocalDatabaseUseCase
import com.example.domain.usecase.GetWeatherForWeekByRegionUseCase
import com.example.domain.usecase.SaveWeatherToLocalDatabaseUseCase
import com.example.domain.usecase.UpdateLocalDatabaseUseCase
import com.example.weatherandroidapp.viewModel.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegionsViewModel(
    private val saveWeatherToLocalDatabaseUseCase: SaveWeatherToLocalDatabaseUseCase,
    private val getListOfRegionsWithWeatherFromLocalDatabaseUseCase: GetListOfRegionsWithWeatherFromLocalDatabaseUseCase,
    private val updateLocalDatabaseUseCase: UpdateLocalDatabaseUseCase
): BaseViewModel() {

    init {
        Log.e("HEIWA", "MainViewModel created")
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    fun insertWeather() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        saveWeatherToLocalDatabaseUseCase.invoke()
    }

    private val mutableListOfRegionsWeatherLD: MutableLiveData<List<Weather<Day<Int>>>> = MutableLiveData()
    val listOfRegionsWeatherLD: LiveData<List<Weather<Day<Int>>>>
        get() { return mutableListOfRegionsWeatherLD }

    fun getListOfRegionsWeather() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        mutableListOfRegionsWeatherLD.postValue(getListOfRegionsWithWeatherFromLocalDatabaseUseCase.invoke())
    }

    fun updateLocalDatabase() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        updateLocalDatabaseUseCase.invoke()
    }
}