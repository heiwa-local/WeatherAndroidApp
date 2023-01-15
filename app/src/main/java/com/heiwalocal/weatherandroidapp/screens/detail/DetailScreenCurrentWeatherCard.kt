package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.weatherandroidapp.ui.theme.ExtendedTheme
import java.time.LocalDate
import java.util.*

@Composable
fun DetailScreenCurrentWeatherCard(
    modifier: Modifier,
    datetime: LocalDate,
    region: String,
    tempFeelsLike: Double,
    windPower: Double,
    pressure: Double,
    temp: String
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = region,
            style = ExtendedTheme.typography.h2,
            color = ExtendedTheme.colors.text
        )
        Text(
            text = "${datetime.dayOfWeek.name
                .lowercase()
                .replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                    else it.toString() }
            }, ${datetime.month.name.lowercase()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} ${datetime.dayOfMonth}, ${datetime.year}",
            style = ExtendedTheme.typography.body1,
            color = ExtendedTheme.colors.text
        )
        Text(
            text = "$temp°",
            style = ExtendedTheme.typography.h1,
            color = ExtendedTheme.colors.text
        )
        Text(
            text = "Feels like $tempFeelsLike°",
            style = ExtendedTheme.typography.body1,
            color = ExtendedTheme.colors.text
        )
        Row(
            modifier = Modifier.
                    padding(top = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Wind speed",
                    style = ExtendedTheme.typography.body1,
                    color = ExtendedTheme.colors.textTint
                )
                Text(
                    text = "${windPower.toString()} m/s",
                    style = ExtendedTheme.typography.body1,
                    color = ExtendedTheme.colors.text
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pressure",
                    style = ExtendedTheme.typography.body1,
                    color = ExtendedTheme.colors.textTint
                )
                Text(
                    text = "${pressure.toString()} mmHg",
                    style = ExtendedTheme.typography.body1,
                    color = ExtendedTheme.colors.text
                )
            }
        }
    }
}