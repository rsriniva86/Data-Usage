package com.demo.datausage.common.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// dark palettes
private val DarkGreenColorPalette = darkColors(
    primary = green200,
    primaryVariant = green700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)


private val DarkBlueColorPalette = darkColors(
    primary = blue200,
    primaryVariant = blue700,
    secondary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)


// Light pallets
private val LightGreenColorPalette = lightColors(
    primary = green500,
    primaryVariant = green700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightBlueColorPalette = lightColors(
    primary = blue500,
    primaryVariant = blue700,
    secondary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)


enum class ColorPallete {
    GREEN, BLUE
}

@Composable
fun ComposeDataUsageTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorPallete: ColorPallete = ColorPallete.GREEN,
    content: @Composable () -> Unit,
) {
    val colors = when (colorPallete) {
        ColorPallete.GREEN -> if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
        ColorPallete.BLUE -> if (darkTheme) DarkBlueColorPalette else LightBlueColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}