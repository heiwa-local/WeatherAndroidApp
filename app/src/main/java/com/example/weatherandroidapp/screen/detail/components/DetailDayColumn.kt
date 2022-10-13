package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entity.Day
import com.example.domain.entity.Hour

@Composable
fun DetailDayColumn(
    days: List<Day<Hour>>?
) {
    if (days != null) {
        LazyColumn(modifier = Modifier
            .padding(top = 10.0.dp)) {

            items(days) {
                DetailDayCard(
                    datetime = it.datetime,
                    temp = it.temp,
                    icon = it.icon,
                    hours = it.hours
                )
            }
        }
    }
}