package com.ecommerce.shopdaily.presentation.screens.main.bag

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.presentation.common.components.appbar.AppBar
import com.ecommerce.shopdaily.presentation.common.components.button.CustomButton
import com.ecommerce.shopdaily.presentation.common.components.feedback.FeedbackLabel
import com.ecommerce.shopdaily.presentation.common.components.product.CircularButton
import com.ecommerce.shopdaily.presentation.common.components.screen.BottomPaddingColumn
import com.ecommerce.shopdaily.presentation.common.components.screen.ScreenTitle
import com.ecommerce.shopdaily.presentation.common.util.feedback.FeedbackType
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.bag.components.BagProduct
import com.ecommerce.shopdaily.presentation.ui.theme.Gray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Bag(mainViewModel: MainViewModel) {
    Scaffold(
        topBar = {
            AppBar(
                isBackEnabled = false,
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            BottomPaddingColumn(verticalScroll = true) {
                ScreenTitle(title = "My Bag")
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