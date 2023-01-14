package com.heiwalocal.weatherandroidapp.screens.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heiwalocal.domain.entities.Weather
import com.heiwalocal.domain.useCases.GetWeatherForecastForTheRegionUseCase
import com.heiwalocal.domain.utilities.Response
import com.heiwalocal.weatherandroidapp.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailScreenViewModel(
    private val getWeatherForecastForTheRegionUseCase: GetWeatherForecastForTheRegionUseCase
): BaseViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    private val mutableWeatherForecast = MutableLiveData<Response<Weather>>()
    val weatherForecast: LiveData<Response<Weather>>
        get() { return mutableWeatherForecast }

    fun getWeatherForecast(region: String) = launch(Dispatchers.IO + coroutineExceptionHandler) {
        mutableWeatherForecast.postValue(getWeatherForecastForTheRegionUseCase.invoke(region = region))
    }
}