package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailHeader(
    temperature: Double?
) {
    var temp = "$temperature°C"
    if (temperature != null){
        if (temperature > 0){
            temp = "+$temperature°C"
        }
    } else {
        temp = "No data :("
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.0.dp, start = 10.0.dp, end = 10.0.dp)
        .border(2.dp, Color.White, RoundedCornerShape(15)),
        shape = RoundedCornerShape(15) ,
        color = Color.Black.copy(alpha = 0f)
    ){
        Box(
            modifier = Modifier
                .padding(start = 10.0.dp, end = 10.0.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = temp,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}