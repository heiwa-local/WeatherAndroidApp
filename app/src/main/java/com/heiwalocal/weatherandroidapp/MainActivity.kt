package com.heiwalocal.weatherandroidapp

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.heiwalocal.domain.useCases.GetWeatherForecastForTheRegionUseCase
import com.heiwalocal.weatherandroidapp.screens.detail.DetailScreen
import com.heiwalocal.weatherandroidapp.screens.detail.DetailScreenViewModel
import com.heiwalocal.weatherandroidapp.ui.theme.WeatherAndroidAppTheme
import java.util.*

class MainActivity : ComponentActivity() {

    private val vm by viewModel<DetailScreenViewModel>()

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var currentRegion = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLocation()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            WeatherAndroidAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DetailScreen(viewModel = vm, region = currentRegion.value)
                }
            }
        }
    }

    private fun getLocation(){
        if (checkPermission()) {
            if (isLocationEnable()) {
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this){ task ->
                    val location: Location? = task.result
                    if (location == null){
                        Toast.makeText(applicationContext, "Null received", Toast.LENGTH_SHORT).show()
                    } else {
                        val geocoder = Geocoder(this, Locale.getDefault())
                        val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                        val cityName = addresses!![0].getAddressLine(0)
                        val stateName = addresses!![0].getAddressLine(1)
                        val countryName = addresses!![0].getAddressLine(2)
                        currentRegion.value = addresses[0].adminArea

                        Log.e("HEIWA", "${addresses[0].adminArea}")
                    }

                }
            } else {
                Toast.makeText(applicationContext, "Turn on location", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)

            }

        } else {
            requestPermissions()
        }
    }

    private fun isLocationEnable():Boolean{
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_ACCESS_LOCATION
        )
    }

    companion object{
        private const val PERMISSION_REQUEST_ACCESS_LOCATION = 100
    }

    private fun checkPermission(): Boolean {
        if (ActivityCompat.checkSelfPermission( this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_ACCESS_LOCATION){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "Granted", Toast.LENGTH_SHORT).show()
                getLocation()
            } else {
                Toast.makeText(applicationContext, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}