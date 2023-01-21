package com.example.ecommerce.presentation.pages.main_page.components.main_area.heading

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun AreaHeading(areaType: AreaType) {
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
}