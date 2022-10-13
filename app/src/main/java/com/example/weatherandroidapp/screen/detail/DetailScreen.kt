package com.example.weatherandroidapp.screen.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.screen.components.DetailDayColumn
import com.example.weatherandroidapp.screen.components.DetailHeader
import com.example.weatherandroidapp.screen.components.DetailHourRow
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme
import org.koin.core.KoinApplication.Companion.init
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExperimentalMaterialApi
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    navController: NavController
) {
//    detailViewModel.getListOfWeatherForWeekByRegion()
    val currentRegion = detailViewModel.selectedRegionLD.observeAsState()
    val regionWeatherForWeek = detailViewModel.regionWeatherForWeekLD.observeAsState()

//    detailViewModel.updateLocalDatabase()

    if (currentRegion.value != null){
        detailViewModel.getOfWeatherForWeekByRegion(currentRegion.value!!)
    }
    Log.e("HEIWA", regionWeatherForWeek.value?.days?.get(0)?.hours.toString())
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = currentRegion.value ?: "No data",
                        fontSize = 30.sp
                    )
                },
                navigationIcon = if (navController.previousBackStackEntry != null){
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                } else {
                    null
                },
                backgroundColor = ExtendedTheme.colors.topBarColor,
                contentColor = ExtendedTheme.colors.textColor,
                elevation = 12.dp,
            )
        },
        backgroundColor = ExtendedTheme.colors.background,
        content = {
            val icon = regionWeatherForWeek.value?.days?.get(0)?.icon ?: "clear-day"
            var painter = painterResource(id = R.drawable.clear_day)

            if (icon == "rain") {
                painter = painterResource(id = R.drawable.rain)
            } else if ((icon == "cloudy") or (icon == "partly-cloudy-day")) {
                painter = painterResource(id = R.drawable.cloudy)
            }

//            Image(
//                modifier = Modifier
//                    .fillMaxSize(),
//                painter = painter,
//                contentDescription = null,
//                contentScale = ContentScale.Crop
//            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                DetailHeader(
//                    temperature = regionWeatherForWeek.value?.days?.get(0)?.temp
//                )
                DetailDayColumn(days = regionWeatherForWeek.value?.days)
            }
        }
    )
}