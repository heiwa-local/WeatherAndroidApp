package com.example.weatherandroidapp.navigation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.navigation.NavigationRouter

@Composable
fun AppBottomNavigationBar(
    navController: NavHostController
) {
    BottomNavBar(
        items = listOf(
            BottomNavItem(
                name = stringResource(id = R.string.current_name),
                route = NavigationRouter.Current.route,
                icon = Icons.Default.Cloud
            ),
            BottomNavItem(
                name = stringResource(R.string.home_name),
                route = NavigationRouter.Home.route,
                icon = Icons.Default.Menu
            ),
        ),
        navController = navController,
        onItemClick = {
            navController.navigate(it.route)
        }
    )
}