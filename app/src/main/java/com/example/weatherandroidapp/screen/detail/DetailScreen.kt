package com.example.weatherandroidapp.screen.detail

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.screen.components.DetailDayColumn
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme

@ExperimentalMaterialApi
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    navController: NavController
) {
    val currentRegion = detailViewModel.selectedRegionLD.observeAsState()
    val regionWeatherForWeek = detailViewModel.regionWeatherForWeekLD.observeAsState()

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

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DetailDayColumn(days = regionWeatherForWeek.value?.days)
            }
        }
    )
}