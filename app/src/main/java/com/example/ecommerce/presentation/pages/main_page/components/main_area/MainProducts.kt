package com.example.ecommerce.presentation.pages.main_page.components.main_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.pages.main_page.components.products.ProductCard
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType

@Composable
fun MainProducts(areaType: AreaType) {
    val product = Product(
        R.drawable.product_card_image_1,
        "T-Shirt Sailing",
        "Mango Boy",
        10.0,
        0,
        0.0
    )
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(2) {
            ProductCard(areaType, product = product)
        }
    }
}