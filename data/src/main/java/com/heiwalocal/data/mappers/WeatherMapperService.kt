package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.WeatherResponse
import com.heiwalocal.domain.entities.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class WeatherMapperService: BaseMapperRepository <WeatherResponse, Weather> {

    private val localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private val localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    override fun transform(type: WeatherResponse): Weather {

        /** We divide the received weather forecast for
         * today and for the next nine days **/
        val currentDay = type.days[0]
        val forecastDays = type.days.drop(0)

        /** Get the current date and time **/
        val currentDatetime = LocalDateTime.now()

        val currentHour = currentDay.hours[currentDatetime.hour]

        val forecastHours = mutableListOf<ForecastWeatherByHours>()
        val forecastByDays = mutableListOf<ForecastWeatherByDays>()

        currentDay.hours.map { hour ->
            forecastHours.add(
                ForecastWeatherByHours(
                    time = LocalTime.parse(hour.datetime, localTimeFormatter),
                    temp = hour.temp,
                    icon = hour.icon
                )
            )
        }

        forecastDays.map { day ->
            forecastByDays.add(
                ForecastWeatherByDays(
                    date = LocalDate.parse(day.datetime, localDateFormatter),
                    temp = day.temp,
                    icon = day.icon
                )
            )
        }

        val currentWeather = CurrentWeather(
            datetime = currentDatetime.toLocalDate(),
            temp = currentHour.temp,
            icon = currentHour.icon,
            feelsLike = currentHour.feelsLike,
            windSpeed = currentHour.windSpeed,
            pressure = currentHour.pressure
        )

        val forecastWeather = ForecastWeather(
            hours = forecastHours,
            days = forecastByDays
        )

        return Weather(
            current = currentWeather,
            forecast = forecastWeather
        )
    }

    override fun transformToRepository(type: Weather): WeatherResponse {
        TODO("Not yet implemented")
    }
}