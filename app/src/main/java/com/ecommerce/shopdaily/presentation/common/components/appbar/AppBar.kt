package com.ecommerce.shopdaily.presentation.common.components.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String = "",
    elevation: Dp = 0.dp,
    actions: Array<ImageVector> = emptyArray(),
    isBackEnabled: Boolean = true
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
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        },
        navigationIcon = {
            if (isBackEnabled) {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                        null,
                        modifier = Modifier.size(40.dp),
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        },
        actions = {
            if (actions.isNotEmpty()) {
                actions.forEach { action ->
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = action,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    )
}