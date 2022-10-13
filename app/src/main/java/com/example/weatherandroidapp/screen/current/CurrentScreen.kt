package com.example.weatherandroidapp.screen.current

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.screen.components.DetailDayColumn
import com.example.weatherandroidapp.screen.components.DetailHeader
import com.example.weatherandroidapp.screen.current.viewmodel.CurrentViewModel
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme

@Composable
fun CurrentScreen(
    currentViewModel: CurrentViewModel,
    navController: NavController
) {
//    detailViewModel.getListOfWeatherForWeekByRegion()
    val currentRegionWeather = currentViewModel.currentRegionLD.observeAsState()
    currentViewModel.getCurrentWeather()
//    currentViewModel.updateLocalDatabase()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = currentRegionWeather.value?.address ?: "No data",
                        fontSize = 30.sp)
                },
                backgroundColor = ExtendedTheme.colors.topBarColor,
                contentColor = ExtendedTheme.colors.textColor,
                elevation = 12.dp
            )
        },
        backgroundColor = ExtendedTheme.colors.background,
        content = {
//            val icon = currentRegionWeather.value?.days?.get(0)?.icon ?: "clear-day"

//        Image(
//            modifier = Modifier
//                .fillMaxSize(),
//            painter = painter,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DetailHeader(
                    temperature = currentRegionWeather.value?.days?.get(0)?.temp
                )
                DetailDayColumn(days = currentRegionWeather.value?.days)
            }
        }
    )
}