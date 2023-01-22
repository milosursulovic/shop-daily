package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun CircularButton(
    modifier: Modifier,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(30.dp),
        elevation = 5.dp,
        modifier = modifier
    ) {
        IconButton(
            modifier = Modifier.background(color = MaterialTheme.colors.secondary),
            onClick = { onClick() }) {
            Icon(imageVector = icon, contentDescription = null, tint = Gray)
        }
    }
}