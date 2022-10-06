package com.example.weatherandroidapp.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.domain.entity.Day
import com.example.domain.entity.Hour
import com.example.domain.entity.Weather
import com.example.domain.utility.Response
import com.example.weatherandroidapp.di.viewModelsModule
import com.example.weatherandroidapp.ui.theme.WeatherAndroidAppTheme
import com.example.weatherandroidapp.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private var status: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("HEIWA", "MainActivity created")

        viewModel.getStatus()

        setContent {
            WeatherAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModel) {
    val status: Response<Weather<Day<Hour>>>? by viewModel.statusLD.observeAsState(null)
    Text(text = "Hello ${status?.data?.address}!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    WeatherAndroidAppTheme {
//        Greeting("Android")
//    }
//}