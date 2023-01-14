package com.heiwalocal.weatherandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.heiwalocal.domain.useCases.GetWeatherForecastForTheRegionUseCase
import com.heiwalocal.weatherandroidapp.screens.detail.DetailScreen
import com.heiwalocal.weatherandroidapp.screens.detail.DetailScreenViewModel
import com.heiwalocal.weatherandroidapp.ui.theme.WeatherAndroidAppTheme

class MainActivity : ComponentActivity() {

    private val vm by viewModel<DetailScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAndroidAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DetailScreen(viewModel = vm, region = "Moscow")
                }
            }
        }
    }
}