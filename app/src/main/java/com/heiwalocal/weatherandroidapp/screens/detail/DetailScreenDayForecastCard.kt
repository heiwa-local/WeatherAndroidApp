package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.entities.ForecastWeatherByDays
import com.heiwalocal.weatherandroidapp.R
import com.heiwalocal.weatherandroidapp.ui.theme.ExtendedTheme
import java.util.*

@Composable
fun DetailScreenDayForecastCard(
    modifier: Modifier,
    days: List<ForecastWeatherByDays>
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        color = ExtendedTheme.colors.elementBackground
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "Forecast for 10 days",
                style = ExtendedTheme.typography.body1,
                color = ExtendedTheme.colors.text
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                color = ExtendedTheme.colors.textTint
            )
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp, start = 10.dp, end = 10.dp),
//            ) {
//                items(days) { day ->
//                    DetailScreenDayForecastItem(
//                        modifier = modifier
//                            .padding(10.dp),
//                        day = day
//                    )
//                }
//            }
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 2.dp
                    ),
                day = days[0]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[1]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[2]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[3]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[4]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[5]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[6]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[7]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    ),
                day = days[8]
            )
            DetailScreenDayForecastItem(
                modifier = Modifier,
                day = days[4]
            )
        }
    }
}

@Composable
fun DetailScreenDayForecastItem(
    modifier: Modifier,
    day: ForecastWeatherByDays
) {

    val weatherIcon = when (day.icon) {
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
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.4f),
                text = day.date.dayOfWeek.name
                    .lowercase()
                    .replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                    },
                style = ExtendedTheme.typography.body2,
                color = ExtendedTheme.colors.text
            )
            Icon(
                painter = weatherIcon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(40.dp)
            )
            Text(
                text = "${day.temp}°",
                style = ExtendedTheme.typography.body2,
                color = ExtendedTheme.colors.text
            )
        }
    }
}