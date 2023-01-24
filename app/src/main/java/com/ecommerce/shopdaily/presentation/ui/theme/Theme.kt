package com.ecommerce.shopdaily.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = LightPrimary,
    onPrimary = White,
    error = Error,
    onError = White,
    secondary = White,
    onSecondary = Gray,
    background = LightBackground,
    onBackground = Black
)

private val DarkColorPalette = lightColors(
    primary = DarkPrimary,
    onPrimary = White,
    error = Error,
    onError = White,
    secondary = Dark,
    onSecondary = OrdinaryText,
    background = DarkBackground,
    onBackground = White
)

@Composable
fun ShopDailyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}