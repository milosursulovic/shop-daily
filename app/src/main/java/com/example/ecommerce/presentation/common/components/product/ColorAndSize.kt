package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun ColorAndSize() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            Text(text = "Color: ", style = MaterialTheme.typography.h4, color = Gray)
            Text(
                text = "Black",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Row {
            Text(text = "Size: ", style = MaterialTheme.typography.h4, color = Gray)
            Text(
                text = "L",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}