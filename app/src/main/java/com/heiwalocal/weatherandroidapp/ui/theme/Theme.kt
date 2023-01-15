package com.heiwalocal.weatherandroidapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

data class ExtendedColors(
    val text: Color,
    val textTint: Color,
    val elementBackground: Color,
    val selectedPrimary: Color
)

private val ExtendedDarkColorPalette by lazy {
    ExtendedColors(
        text = Color(0xFF292929),
        textTint = Color(0xFF001021),
        elementBackground = LightBlueTransparent,
        selectedPrimary = Color.White
    )
}

private val ExtendedLightColorPalette by lazy {
    ExtendedColors(
        text = White,
        textTint = WhiteTransparent,
        elementBackground = LightBlueTransparent,
        selectedPrimary = OrangeTransparent
    )
}

val ExtendedLocalColorPalette = staticCompositionLocalOf {
    ExtendedColors(
        text = Color.Unspecified,
        textTint = Color.Unspecified,
        elementBackground = Color.Unspecified,
        selectedPrimary = Color.Unspecified
    )
}

@Composable
fun WeatherAndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent)

    val extendedColors = if (darkTheme) {
        ExtendedDarkColorPalette
    } else {
        ExtendedLightColorPalette
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        ExtendedLocalColorPalette provides extendedColors,
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object ExtendedTheme {
    val colors: ExtendedColors
        @Composable
        @ReadOnlyComposable
        get() = ExtendedLocalColorPalette.current
    val typography = Typography
}