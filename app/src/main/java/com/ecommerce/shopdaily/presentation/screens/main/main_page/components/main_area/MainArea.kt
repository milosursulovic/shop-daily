package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.main_area

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.main_page.components.products.ProductsRow
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
import com.ecommerce.shopdaily.presentation.ui.theme.Gray

@Composable
fun MainArea(productType: ProductType, mainViewModel: MainViewModel) {
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
                    text = when (productType) {
                        is ProductType.New -> "New"
                        is ProductType.Sale -> "Sale"
                    },
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = when (productType) {
                        is ProductType.New -> "You've never seen it before!"
                        is ProductType.Sale -> "Super summer sale"
                    },
                    style = MaterialTheme.typography.h4,
                    color = Gray
                )
            }
            Text(
                text = "View all",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground
            )
        }
        val products = when (productType) {
            is ProductType.New -> mainViewModel.newProducts
            is ProductType.Sale -> mainViewModel.saleProducts
        }
        ProductsRow(products, mainViewModel = mainViewModel)
    }
}