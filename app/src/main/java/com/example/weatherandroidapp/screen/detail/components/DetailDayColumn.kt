package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.weatherandroidapp.screen.detail.components.DetailBaseDayCard

@Composable
fun DetailDayColumn(
    days: List<Day<Hour>>?
) {
    if (days != null) {

        val baseDay = days.get(0)
        val anotherDays = days.drop(1)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            DetailBaseDayCard(
                datetime = baseDay.datetime,
                temp = baseDay.temp,
                icon = baseDay.icon,
                description = baseDay.description ?: "No data",
                hours = baseDay.hours
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 10.0.dp)
            ) {

                items(anotherDays) {
                    DetailDayCard(
                        datetime = it.datetime,
                        temp = it.temp,
                        icon = it.icon,
                        description = it.description ?: "No data",
                        hours = it.hours
                    )
                }
            }
        }
    }
}