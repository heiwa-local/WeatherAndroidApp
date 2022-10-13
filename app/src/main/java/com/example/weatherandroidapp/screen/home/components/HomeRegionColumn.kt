package com.example.weatherandroidapp.screen.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeableDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.domain.entity.Day
import com.example.domain.entity.Weather
import com.example.weatherandroidapp.screen.components.HomeRegionCard
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeRegionColumn(
    regions: List<Weather<Day<Int>>>?,
    navController: NavController,
    onSelectRegion: (selectedRegion: String) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (regions == null) {
            items(1) {
                Text(
                    text = "Nothing",
                    color = Color.White
                )
            }
        } else {
            items(regions) {
                HomeRegionCard(
                    regionName = it.address,
                    temp = it.days.get(0).temp,
                    icon = it.days.get(0).icon,
                    description = it.description,
                    navController = navController,
                    clickAction = onSelectRegion
                )
            }
        }
    }
}