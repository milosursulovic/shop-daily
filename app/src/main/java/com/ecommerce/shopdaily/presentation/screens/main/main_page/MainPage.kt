package com.ecommerce.shopdaily.presentation.screens.main.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecommerce.shopdaily.R
import com.ecommerce.shopdaily.presentation.common.components.button.CustomButton
import com.ecommerce.shopdaily.presentation.common.components.screen.BottomPaddingColumn
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.main_page.components.main_area.MainArea
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_page.ProductType

@Composable
fun MainPage(viewModel: MainViewModel) {
    BottomPaddingColumn(verticalScroll = true, justBottomPadding = true) {
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
        MainArea(
            productType = ProductType.New,
            mainAreaLabel = "New",
            mainAreaSubtitle = "You've never seen it before!",
            viewModel = viewModel
        )
        Spacer(modifier = Modifier.height(10.dp))
        MainArea(
            productType = ProductType.Sale,
            mainAreaLabel = "Sale",
            mainAreaSubtitle = "Super summer sale",
            viewModel = viewModel
        )
    }
}