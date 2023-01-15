package com.heiwalocal.weatherandroidapp.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.heiwalocal.domain.entities.ForecastWeatherByHours
import com.heiwalocal.weatherandroidapp.R
import com.heiwalocal.weatherandroidapp.ui.theme.ExtendedTheme
import com.heiwalocal.weatherandroidapp.ui.theme.WhiteTransparent
import java.time.LocalTime

@Composable
fun DetailScreenHourForecastCard(
    modifier: Modifier,
    hours: List<ForecastWeatherByHours>,
    description: String
) {
    Surface(
        modifier = modifier,
        color = ExtendedTheme.colors.elementBackground,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier
              .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = description,
                style = ExtendedTheme.typography.body1,
                color = ExtendedTheme.colors.text
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, end = 10.dp),
                color = WhiteTransparent
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
            ){
                items(hours) { hour ->
                    DetailScreenHourForecastItem(
                        hour = hour
                    )
                }
            }
        }
    }
}