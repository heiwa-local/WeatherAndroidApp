package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.ui.theme.ExtendedTheme
import java.time.format.DateTimeFormatter

@Composable
fun DetailHourCard(
    time: String,
    temp: Double
) {
    var temperature = "$temp°C"
    if (temp > 0){
        temperature = "+$temp°C"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
            .background(Color(0xFFFFFF).copy(alpha = 0f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = time,
            fontSize = 18.sp,
            color = ExtendedTheme.colors.textColor
        )
        Text(
            text = temperature,
            fontSize = 25.sp,
            color = ExtendedTheme.colors.textColor,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}