package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.heiwalocal.domain.entities.Weather
import com.heiwalocal.domain.utilities.ResponseStatus
import com.heiwalocal.weatherandroidapp.R
import java.time.LocalDateTime

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    region: String
) {
    viewModel.getWeatherForecast(region = region)

    val weather = viewModel.weatherForecast.observeAsState().value
    var weatherBackgroundPainter: Painter

    val currentDateTime = LocalDateTime.now()

    Scaffold {
        if (weather != null) {
            if (weather.status == ResponseStatus.SUCCESS) {

                val weather: Weather = weather.data!!

                weatherBackgroundPainter = when (weather.current.icon) {
                    "snow" -> painterResource(id = R.drawable.snowy_day)
                    "cloudy" -> painterResource(id = R.drawable.cloudy_day)
                    "clear" -> painterResource(id = R.drawable.clear_day)
                    "rain" -> painterResource(id = R.drawable.rainy_day)
                    else -> painterResource(id = R.drawable.clear_day)
                }
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(10.dp),
                    contentScale = ContentScale.Crop,
                    painter = weatherBackgroundPainter,
                    contentDescription = "Weather background image"
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
//                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight(0.05f)
                    )
                    DetailScreenCurrentWeatherCard(
                        modifier = Modifier
                            .padding(top = 20.dp),
                        datetime = weather.current.datetime,
                        region = region,
                        tempFeelsLike = weather.current.feelsLike,
                        windPower = weather.current.windSpeed,
                        pressure = weather.current.pressure,
                        temp = weather.current.temp.toString()
                    )
                    DetailScreenHourForecastCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 10.dp,
                                end = 10.dp,
                                top = 30.dp
                            ),
                        hours = weather.forecast.hours,
                        description = weather.forecast.description
                    )
                }
            }
        }
    }
}