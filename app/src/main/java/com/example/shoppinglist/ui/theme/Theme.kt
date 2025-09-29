package com.example.shoppinglist.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = GreyDark,
    onPrimary = GreyOn,
    primaryContainer = GreyDarkPrimaryContainer,
    onPrimaryContainer = GreyDarkOnPrimaryContainer,
    secondary = GreySecondary,
    secondaryContainer = GreyDarkSecondaryContainer,
    onSecondaryContainer = GreyDarkOnSecondaryContainer,
    background = GreyDarkBackground,
    onBackground = GreyDarkOnBackground,
    surface = GreyDarkSurface,
    onSurface = GreyDarkOnSurface
)

private val LightColorScheme = lightColorScheme(
    primary = GreyPrimary,
    onPrimary = GreyOn,
    primaryContainer = GreyPrimaryContainer,
    onPrimaryContainer = GreyOnPrimaryContainer,
    secondary = GreySecondary,
    secondaryContainer = GreySecondaryContainer,
    onSecondaryContainer = GreyOnSecondaryContainer,
    background = GreyBackground,
    onBackground = GreyOnBackground,
    surface = GreySurface,
    onSurface = GreyOnSurface
)

@Composable
fun ShoppingListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Pastikan Anda memiliki objek Typography yang sesuai
        shapes = Shapes, // Pastikan Anda memiliki objek Shapes yang sesuai
        content = content
    )
}