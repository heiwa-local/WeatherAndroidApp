package com.example.weatherandroidapp.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import com.example.weatherandroidapp.screen.components.HomeRegionCard
import com.example.weatherandroidapp.screen.home.components.HomeRegionColumn
import com.example.weatherandroidapp.screen.home.viewmodel.HomeViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme
import com.example.weatherandroidapp.ui.theme.WeatherAndroidAppTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.Delay
import kotlinx.coroutines.coroutineScope

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController,
    onSelectRegion: (selectedRegion: String) -> Unit
) {
    val listOfRegionsWeather = homeViewModel.listOfRegionsWeatherLD.observeAsState()
//    homeViewModel.updateLocalDatabase()
    homeViewModel.getListOfRegionsWeather()

    val swipeRefreshState = rememberSwipeRefreshState(false)
    val painter = painterResource(id = R.drawable.clear_day)

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
//            Image(
//                modifier = Modifier
//                    .fillMaxSize(),
//                painter = painter,
//                contentDescription = null,
//                contentScale = ContentScale.Crop)

            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {homeViewModel.updateLocalDatabase() }
            ) {
                HomeRegionColumn(
                    regions = listOfRegionsWeather.value,
                    navController = navController,
                    onSelectRegion = onSelectRegion
                )
            }

        }
    )
}