package com.example.weatherandroidapp.screen.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.screen.settings.viewmodel.SettingsViewModel
import com.example.weatherandroidapp.ui.theme.ExtendedTheme

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel,
    navController: NavController
) {

//    val listOfRegions =
    val themeCheckedState = remember { mutableStateOf(true) }
    val regionCheckedState = remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Settings",
                        fontSize = 30.sp
                    )
                },
                contentColor = ExtendedTheme.colors.textColor,
                backgroundColor = ExtendedTheme.colors.topBarColor,
                elevation = 12.dp
            )
        },
        backgroundColor = ExtendedTheme.colors.background,
        modifier = Modifier
            .fillMaxSize(),
        content = {
//            Image(
//                modifier = Modifier
//                    .fillMaxSize(),
//                painter = painterResource(id = R.drawable.clear_day),
//                contentDescription = null,
//                contentScale = ContentScale.Crop
//            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text(text = "Auto theme")
                    Switch(checked = themeCheckedState.value, onCheckedChange = {
                        themeCheckedState.value = it
                    })
                }
                Row {
                    Text(text = "Auto region")
                    Switch(checked = regionCheckedState.value, onCheckedChange = {
                        regionCheckedState.value = it
                    })
                }
                Button(
                    onClick = { settingsViewModel.updateLocalDatabase() }) {
                    Text(text = "Update")
                }
            }
        }
    )
}