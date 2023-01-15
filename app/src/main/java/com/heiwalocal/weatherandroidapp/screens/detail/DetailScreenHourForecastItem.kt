package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.entities.ForecastWeatherByHours
import com.heiwalocal.weatherandroidapp.R
import com.heiwalocal.weatherandroidapp.ui.theme.ExtendedTheme
import java.time.LocalTime

@Composable
fun DetailScreenHourForecastItem(
    hour: ForecastWeatherByHours
) {
    val localTime = LocalTime.now()
    val weatherIcon = when (hour.icon) {
        "clear-day" ->  painterResource(id = R.drawable.ic_clear_day)
        "rain" -> painterResource(id = R.drawable.ic_rain)
        "cloudy" -> painterResource(id = R.drawable.ic_cloudy)
        "partly-cloudy-day" -> painterResource(id = R.drawable.ic_partly_cloudy_day)
        "snow" -> painterResource(id = R.drawable.ic_cloudy)
        "fog" -> painterResource(id = R.drawable.ic_cloudy)
        "wind" -> painterResource(id = R.drawable.ic_partly_cloudy_day)
        "partly-cloudy-night" -> painterResource(id = R.drawable.ic_partly_cloudy_night)
        "clear-night" -> painterResource(id = R.drawable.ic_clear_night)
        else -> painterResource(id = R.drawable.ic_rain)
    }

    val surfaceColor: Color
    val time: String

    when (hour.time.hour) {
        localTime.hour -> {
            surfaceColor =  ExtendedTheme.colors.selectedPrimary
            time = "now"
        }
        else -> {
            surfaceColor = Color.Transparent
            time = hour.time.hour.toString()
        }
    }

    Surface(
        modifier = Modifier
            .padding(5.dp),
        color = surfaceColor,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = time,
                style = ExtendedTheme.typography.body2,
                color = ExtendedTheme.colors.textTint
            )
            Icon(
                painter = weatherIcon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(40.dp)
            )
            Text(
                text = "${hour.temp}°",
                style = ExtendedTheme.typography.body2,
                color = ExtendedTheme.colors.text
            )
        }
    }
}