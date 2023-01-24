package com.ecommerce.shopdaily.presentation.screens.login.components.custom_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForgotPassword() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Forgot you password?", style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground
        )
        IconButton(onClick = { }) {
            Icon(
                Icons.Outlined.ArrowForward,
                null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.primary
            )
        }
    }
}