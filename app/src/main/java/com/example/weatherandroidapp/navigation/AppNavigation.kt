package com.example.weatherandroidapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherandroidapp.navigation.component.AppBottomNavigationBar
import com.example.weatherandroidapp.screen.current.CurrentScreen
import com.example.weatherandroidapp.screen.current.viewmodel.CurrentViewModel
import com.example.weatherandroidapp.screen.detail.DetailScreen
import com.example.weatherandroidapp.screen.detail.viewmodel.DetailViewModel
import com.example.weatherandroidapp.screen.home.RegionsScreen
import com.example.weatherandroidapp.screen.home.viewmodel.RegionsViewModel
import com.example.weatherandroidapp.screen.settings.SettingsScreen
import com.example.weatherandroidapp.screen.settings.viewmodel.SettingsViewModel

@ExperimentalMaterialApi
@Composable
fun AppNavigation(
    homeViewModel: RegionsViewModel,
    detailViewModel: DetailViewModel,
    currentViewModel: CurrentViewModel,
    settingsViewModel: SettingsViewModel
) {
    val navController = rememberNavController()
    val ARGUMENT_KEY: String = "regionName"
    Scaffold(
        bottomBar = {
            AppBottomNavigationBar(navController)
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationRouter.Home.route
        ) {
            composable(NavigationRouter.Home.route) {
                RegionsScreen(
                    regionsViewModel = homeViewModel,
                    navController = navController,
                    onSelectRegion = detailViewModel::setCurrentRegion
                )
            }
            composable(NavigationRouter.Detail.route) {
                DetailScreen(
                    detailViewModel = detailViewModel,
                    navController = navController,
                )
            }
            composable(NavigationRouter.Current.route) {
                CurrentScreen(
                    currentViewModel = currentViewModel,
                    navController = navController)
            }
            composable(NavigationRouter.Settings.route){
                SettingsScreen(
                    settingsViewModel = settingsViewModel,
                    navController = navController
                )
            }
        }
    }
}