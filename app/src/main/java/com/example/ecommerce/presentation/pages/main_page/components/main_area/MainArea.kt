package com.example.ecommerce.presentation.pages.main_page.components.main_area

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.data.remote.FakeApi
import com.example.ecommerce.presentation.pages.main_page.components.products.ProductCard
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Gray

val fakeApi = FakeApi()

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
        val products = when (areaType) {
            is AreaType.New -> fakeApi.getNewProducts()
            is AreaType.Sale -> fakeApi.getSaleProducts()
        }
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(products) { product ->
                ProductCard(areaType, product = product)
            }
        }
    }
}