package com.example.ecommerce.presentation.pages.main_page.components.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType

@Composable
fun ProductCard(
    areaType: AreaType,
    product: Product
) {
    Column {
        ProductTopArea(areaType, product)
        Spacer(modifier = Modifier.height(10.dp))
        ProductBottomArea(areaType, product)
    }
}