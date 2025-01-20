package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.main_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.main_page.components.product.ProductsRow
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_page.ProductType
import com.ecommerce.shopdaily.presentation.ui.theme.Gray

@Composable
fun MainArea(
    productType: ProductType,
    mainAreaLabel: String,
    mainAreaSubtitle: String,
    viewModel: MainViewModel
) {
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
                    text = mainAreaLabel,
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = mainAreaSubtitle,
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
        ProductsRow(productType = productType, viewModel = viewModel)
    }
}