package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun DetailScreenCurrentWeatherItem(
    modifier: Modifier,
    datetime: LocalDate,
    region: String,
    tempFeelsLike: Double,
    windPower: Double,
    rainChance: Double,
    temp: String
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = region
        )
        Text(
            text = "${datetime.dayOfWeek.name
                .lowercase()
                .replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                    else it.toString() }
            }, ${datetime.month.name.lowercase()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} ${datetime.dayOfMonth}, ${datetime.year}",
        )
        Text(
            text = "$temp°"
        )
        Text(
            text = "Feels like $tempFeelsLike°"
        )
        Row(
            modifier = Modifier
        ) {
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Text(text = windPower.toString())
            }
            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                Text(text = rainChance.toString())
            }
        }
    }
}