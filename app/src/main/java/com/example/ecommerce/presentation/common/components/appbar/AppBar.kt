package com.example.ecommerce.presentation.common.components.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.ui.theme.Black

@Composable
fun AppBar(
    title: String = "",
    elevation: Dp = 0.dp,
    vararg actions: ImageVector = emptyArray(),
    onBackPressed: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = elevation,
        title = {
            if (title != "") {
                Row(
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h3,
                        color = Black
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    null,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {
            if (actions.isNotEmpty()) {
                actions.forEach { action ->
                    IconButton(onClick = { }) {
                        Icon(imageVector = action, contentDescription = null)
                    }
                }
            }
        }
    )
}