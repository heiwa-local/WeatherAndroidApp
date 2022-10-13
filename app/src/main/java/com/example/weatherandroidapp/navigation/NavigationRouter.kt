package com.example.weatherandroidapp.navigation

sealed class NavigationRouter(val route: String ) {
    object Home: NavigationRouter("home")
    object Detail: NavigationRouter("detail")
    object Current: NavigationRouter("current")
    object Settings: NavigationRouter("settings")
}