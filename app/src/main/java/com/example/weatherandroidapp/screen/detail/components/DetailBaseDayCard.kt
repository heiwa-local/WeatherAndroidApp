package com.example.weatherandroidapp.screen.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entity.Hour
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.screen.components.DetailHourRow
import com.example.weatherandroidapp.ui.theme.ExtendedTheme

@Composable
fun DetailBaseDayCard(
    datetime: String,
    temp: Double,
    icon: String?,
    description: String,
    hours: List<Hour>
) {

    var temperature = "$temp°C"
    if (temp > 0){
        temperature = "+$temp°C"
    }

    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .padding(10.0.dp)
        .shadow(
            elevation = 10.dp,
            spotColor = Color.Black,
            shape = RoundedCornerShape(size = 8.dp)
        ),
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
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .blur(10.dp)
        )
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = datetime,
                fontSize = 20.sp,
                color = ExtendedTheme.colors.textColor
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = temperature,
                    fontSize = 60.sp,
                    color = ExtendedTheme.colors.textColor
                )
                Text(
                    text = description,
                    fontSize = 15.sp,
                    color = ExtendedTheme.colors.textColor,
                    textAlign = TextAlign.Center
                )
            }
            DetailHourRow(hours = hours)
        }
    }
}