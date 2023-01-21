package com.example.ecommerce.presentation.pages.main_page.components.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Hot
import com.example.ecommerce.presentation.ui.theme.White

@Composable
fun ProductTopArea(areaType: AreaType, product: Product) {
    Box {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .clip(RoundedCornerShape(10.dp))
                .width(150.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = when (areaType) {
                    is AreaType.New -> "NEW"
                    is AreaType.Sale -> "-${product.discount}%"
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (areaType) {
                            is AreaType.New -> Black
                            is AreaType.Sale -> Hot
                        }
                    )
                    .padding(5.dp),
                style = MaterialTheme.typography.h4,
                color = White
            )
        }
    }
}