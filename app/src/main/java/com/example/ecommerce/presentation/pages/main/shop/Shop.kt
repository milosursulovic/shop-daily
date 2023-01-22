@file:OptIn(ExperimentalPagerApi::class)
@file:SuppressLint("UnusedMaterialScaffoldPaddingParameter")

package com.example.ecommerce.presentation.pages.main.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.White
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@Composable
fun Shop() {
    val categories = listOf("Women", "Men", "Kids")
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = {
            AppBar(
                title = "Categories",
                elevation = 5.dp,
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            //tab layout
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = MaterialTheme.colors.primary
                    )
                }
            ) {
                categories.forEachIndexed { index, category ->
                    Tab(
                        modifier = Modifier.background(color = White),
                        text = {
                            Text(category, style = MaterialTheme.typography.body1, color = Black)
                        },
                        selected = pagerState.currentPage == index,
                        onClick = { },
                    )
                }
            }
            //top banner
            //categories
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {

            }
        }
    )
}