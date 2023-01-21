package com.example.ecommerce.presentation.pages.main_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.pages.main_page.components.big_banner.BigBanner
import com.example.ecommerce.presentation.pages.main_page.components.main_area.MainArea
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType

@Composable
fun MainPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BigBanner()
        MainArea(AreaType.New)
        Spacer(modifier = Modifier.height(10.dp))
        MainArea(AreaType.Sale)
    }
}