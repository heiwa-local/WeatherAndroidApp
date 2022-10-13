package com.example.weatherandroidapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
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
    secondary = Teal200,
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
    val background: Color,
    val onBackground: Color,
    val borderColor: Color,
    val textColor: Color,
    val selectedColor: Color,
    val unSelectedColor: Color,
    val topBarColor: Color,
    val navBarColor: Color,
    val systemBarColor: Color
)

private val DarkExtendedColors by lazy {
    ExtendedColors(
        background = Color(0xFF292929),
        onBackground = Color(0xFF001021),
        borderColor = Color(0xFF161517),
        textColor = Color(0xFFF2F3F4),
        topBarColor = Color(0xFF292929),
        navBarColor = Color(0xFF292929),
        selectedColor = Color(0xFFF2F3F4),
        unSelectedColor = Color(0x80F2F3F4),
        systemBarColor = Color(0xFF292929)
    )
}

private val LightExtendedColors by lazy {
    ExtendedColors(
        background = Color(0xFF97B4E0),
        onBackground = Color(0xFF001021),
        borderColor = Color.Black,
        textColor = Color(0xFFF2F3F4),
        topBarColor = Color(0xFF97B4E0),
        navBarColor = Color(0xFF97B4E0),
        selectedColor = Color(0xFFF2F3F4),
        unSelectedColor = Color(0x80F2F3F4),
        systemBarColor = Color(0xFF97B4E0)

    )
}

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        borderColor = Color.Black,
        textColor = Color.Unspecified,
        topBarColor = Color.Unspecified,
        navBarColor = Color.Unspecified,
        selectedColor = Color.Unspecified,
        unSelectedColor = Color.Unspecified,
        systemBarColor = Color.Unspecified
    )
}

@Composable
fun WeatherAndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) {
        DarkExtendedColors
    } else {
        LightExtendedColors
    }

    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = extendedColors.systemBarColor
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = extendedColors.systemBarColor
        )
    }

    val colorPalette = when {
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }
    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
    ) {
        MaterialTheme(
            colors = colorPalette,
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
        get() = LocalExtendedColors.current
}