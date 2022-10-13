package com.example.weatherandroidapp.screen.current

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.screen.components.DetailDayColumn
import com.example.weatherandroidapp.screen.current.viewmodel.CurrentViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme

@Composable
fun CurrentScreen(
    currentViewModel: CurrentViewModel,
    navController: NavController
) {
    val currentRegionWeather = currentViewModel.currentRegionLD.observeAsState()
    currentViewModel.getCurrentWeather()

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

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DetailDayColumn(days = currentRegionWeather.value?.days)
            }
        }
    )
}