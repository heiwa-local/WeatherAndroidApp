package com.example.weatherandroidapp.screen.components

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherandroidapp.R
import com.example.weatherandroidapp.navigation.NavigationRouter

@ExperimentalMaterialApi
@Composable
fun RegionCard(
    regionName: String,
    temp: kotlin.Double,
    icon: String?,
    description: String,
    navController: NavController,
    clickAction: (region: String) -> Unit
) {
    var temperature = "Unknown"

    val arguments = Bundle().putString("regionName",regionName)

    temperature = if (temp <= 0){
        "$temp°C"
    } else {
        "+$temp°C"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.0.dp)
            .padding(10.0.dp)
            .shadow(
                elevation = 10.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(size = 8.dp)
            ),
        shape = RoundedCornerShape(8),
        onClick = {
            clickAction(regionName)
            return@Card navController.navigate(NavigationRouter.Detail.route)
        }
    ) {
        var painter = painterResource(id = R.drawable.clear_day)
        if (icon == "rain") {
            painter = painterResource(id = R.drawable.rain)
        } else if (icon == "cloudy"){
            painter = painterResource(id = R.drawable.cloudy)
        }
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .blur(10.dp)
        )
        Column(
            modifier = Modifier.padding(10.0.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = regionName,
                    modifier = Modifier
                        .padding(start = 10.0.dp),
                    fontSize = 30.sp,
                    color = Color.White
                )
                Text(
                    text = temperature,
                    fontSize = 50.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.0.dp, end = 10.0.dp)
                )
            }
            Text(
                text = description,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

    }
}