package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.product.*

@Composable
fun ProductCard(
    product: Product,
    onProductClick: (Product) -> Unit
) {
    Column(
        modifier = Modifier.clickable { onProductClick(product) }
    ) {
        Box {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp),
                contentScale = ContentScale.Crop
            )
            CircularButton(modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 0.dp, y = 15.dp),
                iconModifier = Modifier
                    .width(15.dp)
                    .height(15.dp),
                icon = Icons.Outlined.FavoriteBorder,
                tint = MaterialTheme.colors.onSecondary,
                onClick = {})
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProductRating(product = product)
        ProductSubtitle(product = product)
        ProductTitle(product = product)
        ProductPrice(product = product, modifier = Modifier.fillMaxWidth())
    }
}