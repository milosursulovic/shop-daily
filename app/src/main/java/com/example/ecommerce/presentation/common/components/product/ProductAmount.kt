package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProductAmount() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularButton(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp), icon = Icons.Outlined.Add
        ) {}
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "1",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(20.dp))
        CircularButton(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp), icon = Icons.Outlined.Add
        ) {}
    }
}