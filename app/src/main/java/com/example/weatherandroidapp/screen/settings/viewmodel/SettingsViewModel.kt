package com.example.weatherandroidapp.screen.settings.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.InsertCurrentRegionUseCase
import com.example.domain.usecase.UpdateLocalDatabaseUseCase
import com.example.weatherandroidapp.viewModel.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val insertCurrentRegionUseCase: InsertCurrentRegionUseCase,
    private val updateLocalDatabaseUseCase: UpdateLocalDatabaseUseCase
): BaseViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val mutableThemeCheckLD: MutableLiveData<Boolean> = MutableLiveData()
    val themeCheckLD: LiveData<Boolean>
        get() { return mutableThemeCheckLD }

    fun changeTheme(){

    }

    fun updateLocalDatabase() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        updateLocalDatabaseUseCase.invoke()
    }

}