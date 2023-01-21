package com.example.ecommerce.presentation.common.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    onBackClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
        title = {},
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    null,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {}
    )
}