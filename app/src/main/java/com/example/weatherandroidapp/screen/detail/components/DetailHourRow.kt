package com.example.weatherandroidapp.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.entity.Hour

@Composable
fun DetailHourRow(
    hours: List<Hour>?
) {

    if (hours != null) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(hours) {
                DetailHourCard(time = it.datetime, temp = it.temp)
            }
        }
    }
}