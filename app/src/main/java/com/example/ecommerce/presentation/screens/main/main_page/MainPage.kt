package com.example.ecommerce.presentation.screens.main.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.presentation.common.components.button.CustomButton
import com.example.ecommerce.presentation.screens.main.MainViewModel
import com.example.ecommerce.presentation.screens.main.main_page.components.main_area.MainArea
import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType

@Composable
fun MainPage(mainViewModel: MainViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = screenHeight * 0.15f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_page_top_image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(bottom = 10.dp, start = 10.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Fashion\nSale",
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    fontFamily = FontFamily(Font(R.font.metrophobic_regular, FontWeight.Bold))
                )
                CustomButton(modifier = Modifier
                    .width(200.dp),
                    textModifier = Modifier.padding(vertical = 5.dp),
                    text = "Check",
                    onClick = { })
            }
        }
        MainArea(ProductType.New, mainViewModel = mainViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        MainArea(ProductType.Sale, mainViewModel = mainViewModel)
    }
}