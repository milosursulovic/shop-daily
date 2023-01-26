@file:OptIn(ExperimentalPagerApi::class)
@file:SuppressLint("UnusedMaterialScaffoldPaddingParameter")

package com.ecommerce.shopdaily.presentation.screens.main.shop

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.appbar.AppBar
import com.ecommerce.shopdaily.presentation.common.components.feedback.FeedbackLabel
import com.ecommerce.shopdaily.presentation.common.components.screen.Loading
import com.ecommerce.shopdaily.presentation.common.util.feedback.FeedbackType
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.shop.components.CategoryProduct
import com.ecommerce.shopdaily.presentation.screens.main.shop.components.ProductCategory
import com.ecommerce.shopdaily.presentation.screens.main.util.category.CategoryEvent
import com.ecommerce.shopdaily.presentation.screens.main.util.product.ProductEvent
import com.ecommerce.shopdaily.presentation.screens.product.AddToCartActivity
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@Composable
fun Shop(mainViewModel: MainViewModel) {
    val context = LocalContext.current
    val tabItems = listOf("Women", "Men", "Kids")
    val pagerState = rememberPagerState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val categoriesState = mainViewModel.shopCategoriesState
    val categoryState = mainViewModel.categoryState
    val loggedUser = mainViewModel.loggedUser

    var chosenProduct: Product? = null
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val result = activityResult.data?.getBooleanExtra(Constants.ADD_TO_CART, false)
            if (result == true) {
                chosenProduct?.let { product ->
                    mainViewModel.addProduct(product)
                }
            }
        }
    }

    Scaffold(
        topBar = {
            AppBar(
                title = "Categories",
                elevation = 5.dp,
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (categoryState.isCategoryVisible) {
                    if (categoryState.isLoading) {
                        Loading(modifier = Modifier.fillMaxSize())
                    } else {
                        categoryState.category?.let { category ->
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        top = 10.dp,
                                        start = 10.dp,
                                        end = 10.dp,
                                        bottom = screenHeight * 0.15f
                                    ),
                                verticalArrangement = Arrangement.spacedBy(15.dp)
                            ) {
                                items(category.products) { product ->
                                    CategoryProduct(
                                        product = product,
                                        onProductClick = { chosenProd ->
                                            chosenProduct = chosenProd
                                            val intent =
                                                Intent(
                                                    context,
                                                    AddToCartActivity::class.java
                                                ).apply {
                                                    putExtra(Constants.PRODUCT, chosenProduct)
                                                }
                                            launcher.launch(intent)
                                        },
                                        onFavoriteClick = { chosenProd ->
                                            mainViewModel.onProductEvent(
                                                ProductEvent.SaveToFavorites(
                                                    chosenProd
                                                )
                                            )
                                        })
                                }
                            }
                        }
                    }
                } else {
                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                modifier = Modifier.pagerTabIndicatorOffset(
                                    pagerState,
                                    tabPositions
                                ),
                                color = MaterialTheme.colors.primary
                            )
                        }
                    ) {
                        tabItems.forEachIndexed { index, category ->
                            Tab(
                                modifier = Modifier.background(color = MaterialTheme.colors.secondary),
                                text = {
                                    Text(
                                        category,
                                        style = MaterialTheme.typography.body1,
                                        color = MaterialTheme.colors.onSecondary
                                    )
                                },
                                selected = pagerState.currentPage == index,
                                onClick = { },
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(20.dp),
                            elevation = 5.dp
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.background(color = MaterialTheme.colors.primary)
                            ) {
                                Text(
                                    text = "SUMMER SALES",
                                    style = MaterialTheme.typography.h2,
                                    color = MaterialTheme.colors.onPrimary
                                )
                                Text(
                                    text = "Up to 50% off",
                                    style = MaterialTheme.typography.body2,
                                    color = MaterialTheme.colors.onPrimary
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        if (categoriesState.isLoading) {
                            Loading(modifier = Modifier.fillMaxSize())
                        } else {
                            categoriesState.error?.let { errorMessage ->
                                if (errorMessage.isNotBlank()) {
                                    FeedbackLabel(
                                        FeedbackType.Error(errorMessage)
                                    )
                                }
                            }
                            categoriesState.shopCategories?.let { shopCategories ->
                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(
                                            top = 10.dp,
                                            start = 10.dp,
                                            end = 10.dp,
                                            bottom = screenHeight * 0.15f
                                        ),
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    items(shopCategories) { shopCategory ->
                                        ProductCategory(shopCategory = shopCategory) { category ->
                                            mainViewModel.onCategoriesEvent(
                                                CategoryEvent.GetCategory(
                                                    loggedUser?.token!!,
                                                    category.categoryId,
                                                    category.name
                                                )
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}