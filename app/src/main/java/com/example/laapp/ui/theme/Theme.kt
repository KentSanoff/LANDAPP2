package com.kentsanoff.landapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF388E3C),
    onPrimary = Color.White,
    background = Color(0xFFF1F8E9),
    onBackground = Color.Black
)

@Composable
fun LandAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
