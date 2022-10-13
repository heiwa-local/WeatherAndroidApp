package com.example.weatherandroidapp.screen.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.screen.home.components.RegionColumn
import com.example.weatherandroidapp.screen.home.viewmodel.RegionsViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalMaterialApi
@Composable
fun RegionsScreen(
    regionsViewModel: RegionsViewModel,
    navController: NavController,
    onSelectRegion: (selectedRegion: String) -> Unit
) {
    val listOfRegionsWeather = regionsViewModel.listOfRegionsWeatherLD.observeAsState()
    regionsViewModel.getListOfRegionsWeather()

    val swipeRefreshState = rememberSwipeRefreshState(false)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Regions",
                    fontSize = 30.sp)
                },
                backgroundColor = ExtendedTheme.colors.topBarColor,
                contentColor = ExtendedTheme.colors.textColor,
                elevation = 12.dp
            )
        },
        backgroundColor = ExtendedTheme.colors.background,
        content = {

            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {regionsViewModel.updateLocalDatabase() }
            ) {
                RegionColumn(
                    regions = listOfRegionsWeather.value,
                    navController = navController,
                    onSelectRegion = onSelectRegion
                )
            }

        }
    )
}