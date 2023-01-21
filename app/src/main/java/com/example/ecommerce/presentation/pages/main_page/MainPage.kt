package com.example.ecommerce.presentation.pages.main_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecommerce.presentation.pages.main_page.components.MainBigBanner
import com.example.ecommerce.presentation.pages.main_page.components.NewArea

@Composable
fun MainPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MainBigBanner()
        NewArea()
    }
}