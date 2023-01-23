package com.example.ecommerce.presentation.screens.main.favorites

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.components.screen.ScreenTitle
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.screens.main.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Favorites(
    mainViewModel: MainViewModel
) {
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            AppBar(
                isBackEnabled = false,
                onBackPressed = {},
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            val configuration = LocalConfiguration.current
            val screenHeight = configuration.screenHeightDp.dp
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = screenHeight * 0.15f)
            ) {
                ScreenTitle(title = "Favorites")
                if (mainViewModel.favorites.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(mainViewModel.favorites) { favorite ->
                            FavoriteProduct(favorite = favorite)
                        }
                    }
                } else {
                    FeedbackLabel(feedbackType = FeedbackType.Info("No added products to cart yet"))
                }
            }
        })
}