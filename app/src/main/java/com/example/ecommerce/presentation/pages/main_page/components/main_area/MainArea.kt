package com.example.ecommerce.presentation.pages.main_page.components.main_area

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.pages.main_page.components.products.ProductCard
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun MainArea(areaType: AreaType) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = when (areaType) {
                        is AreaType.New -> "New"
                        is AreaType.Sale -> "Sale"
                    },
                    style = MaterialTheme.typography.h1,
                    color = Black
                )
                Text(
                    text = "You've never seen it before!",
                    style = MaterialTheme.typography.h4,
                    color = Gray
                )
            }
            Text(
                text = "View all",
                style = MaterialTheme.typography.h4,
                color = Black
            )
        }
        val product = when (areaType) {
            is AreaType.New -> Product(
                R.drawable.product_card_image_1,
                "T-Shirt Sailing",
                "Mango Boy",
                10.0,
                0,
                0.0
            )
            is AreaType.Sale -> Product(
                R.drawable.product_card_image_2,
                "Evening Dress",
                "Dorothy Perkins",
                15.0,
                20,
                10.0
            )
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(2) {
                ProductCard(areaType, product = product)
            }
        }
    }
}