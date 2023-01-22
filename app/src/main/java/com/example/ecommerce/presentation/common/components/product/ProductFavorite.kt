package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductFavorite(
    modifier: Modifier
) {
    Card(
        elevation = 4.dp,
        modifier = modifier,
        shape = RoundedCornerShape(30.dp)
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier.background(color = MaterialTheme.colors.secondary)
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .width(15.dp)
                    .height(15.dp),
                tint = MaterialTheme.colors.onSecondary
            )
        }
    }
}