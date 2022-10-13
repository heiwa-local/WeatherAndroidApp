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
    Card(modifier = Modifier
        .width(200.dp)
        .height(100.dp)
        .padding(10.dp)
        .border(width = 3.dp, color = Color.White, shape = RoundedCornerShape(8)),
        shape = RoundedCornerShape(8),
        backgroundColor = Color.White.copy(alpha = 0f)
        ) {
//        if (preciptype == "rain"){
//            Image(painter = painterResource(id = R.drawable.rain),
//                contentDescription = null,
//                contentScale = ContentScale.Crop)
//        } else {
//            Image(painter = painterResource(id = R.drawable.sun),
//                contentDescription = null,
//                contentScale = ContentScale.Crop)
//        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = time ?: "No data",
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = temperature,
                fontSize = 40.sp,
                color = Color.White
            )
        }
    }
}