package com.example.ecommerce.presentation.common.components.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun BottomPaddingColumn(verticalScroll: Boolean = false, innerContent: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Column(
        modifier = if (verticalScroll) Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = screenHeight * 0.15f) else
            Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = screenHeight * 0.15f)
    ) {
        innerContent()
    }
}