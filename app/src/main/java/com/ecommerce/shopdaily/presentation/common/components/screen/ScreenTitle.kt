package com.ecommerce.shopdaily.presentation.common.components.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ScreenTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onBackground,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}