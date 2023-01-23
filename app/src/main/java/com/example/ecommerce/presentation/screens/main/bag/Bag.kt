package com.example.ecommerce.presentation.screens.main.bag

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.common.components.button.CustomButton
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.components.product.CircularButton
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.screens.main.MainViewModel
import com.example.ecommerce.presentation.ui.theme.Gray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Bag(mainViewModel: MainViewModel) {
    Scaffold(
        topBar = {
            AppBar(
                isBackEnabled = false,
                actions = arrayOf(Icons.Outlined.Search),
                onBackPressed = {})
        },
        content = {
            val configuration = LocalConfiguration.current
            val screenHeight = configuration.screenHeightDp.dp
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = screenHeight * 0.15f)
            ) {
                Text(
                    text = "My Bag",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                )
                if (mainViewModel.cartProducts.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(600.dp),
                        contentPadding = PaddingValues(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(mainViewModel.cartProducts) { product ->
                            BagProduct(product = product)
                        }
                    }
                } else {
                    FeedbackLabel(feedbackType = FeedbackType.Info("No added products to cart yet"))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 40.dp,
                                    bottomEnd = 40.dp,
                                    topStart = 10.dp,
                                    bottomStart = 10.dp
                                )
                            )
                            .height(60.dp)
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = "Enter your promo code",
                                color = MaterialTheme.colors.onSecondary,
                                style = MaterialTheme.typography.body2
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            backgroundColor = MaterialTheme.colors.secondary,
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            focusedLabelColor = Gray
                        )
                    )
                    CircularButton(modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .align(Alignment.CenterEnd),
                        iconModifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        icon = Icons.Outlined.KeyboardArrowRight,
                        tint = Gray,
                        onClick = {})
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total amount: ",
                        style = MaterialTheme.typography.body2,
                        color = Gray
                    )
                    Text(
                        text = "128$",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(modifier = Modifier
                    .fillMaxWidth(),
                    textModifier = Modifier.padding(vertical = 10.dp),
                    text = "CHECK OUT",
                    onClick = {
                    })
            }
        }
    )
}