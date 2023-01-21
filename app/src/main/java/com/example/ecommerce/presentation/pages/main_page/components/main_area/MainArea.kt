package com.example.ecommerce.presentation.pages.main_page.components.main_area

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.ecommerce.presentation.pages.main_page.components.main_area.heading.AreaHeading
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType

@Composable
fun MainArea(areaType: AreaType) {
    Column {
        AreaHeading(areaType)
        MainProducts(areaType)
    }
}