package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CardImage(modifier: Modifier, image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}