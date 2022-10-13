package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entity.Hour
import com.example.weatherandroidapp.R

@Composable
fun DetailDayCard(
    datetime: String,
    temp: Double,
    icon: String?,
    hours: List<Hour>
) {

    var temperature = "$temp°C"
    if (temp > 0){
        temperature = "+$temp°C"
    }

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .padding(10.0.dp)
        .border(
            width = 3.dp,
            color = Color.White,
            shape = RoundedCornerShape(8)),
        shape = RoundedCornerShape(8)
    ) {
        var painter = painterResource(id = R.drawable.clear_day)
        if (icon == "rain") {
            painter = painterResource(id = R.drawable.rain)
        } else if (icon == "cloudy") {
            painter = painterResource(id = R.drawable.cloudy)
        } else if(icon == "partly-cloudy-day") {
            painter = painterResource(id = R.drawable.cloudy)
        } else {
            painter = painterResource(id = R.drawable.clear_day)
        }
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = datetime,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = temperature,
                    fontSize = 40.sp,
                    color = Color.White
                )
            }
            DetailHourRow(hours = hours)
        }
    }
}