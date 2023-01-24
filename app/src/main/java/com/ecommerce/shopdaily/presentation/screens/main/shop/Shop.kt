@file:OptIn(ExperimentalPagerApi::class)
@file:SuppressLint("UnusedMaterialScaffoldPaddingParameter")

package com.ecommerce.shopdaily.presentation.screens.main.shop

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.presentation.common.components.appbar.AppBar
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.shop.components.ProductCategory
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@Composable
fun Shop(mainViewModel: MainViewModel) {
    val tabItems = listOf("Women", "Men", "Kids")
    val pagerState = rememberPagerState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Scaffold(
        topBar = {
            AppBar(
                title = "Categories",
                elevation = 5.dp,
                actions = arrayOf(Icons.Outlined.Search),
                onBackPressed = {}
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
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
                        items(mainViewModel.categories) { category ->
                            ProductCategory(category = category)
                        }
                    }
                }
            }
        }
    )
}