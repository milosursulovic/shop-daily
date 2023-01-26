package com.ecommerce.shopdaily.presentation.screens.main.favorites

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.presentation.common.components.appbar.AppBar
import com.ecommerce.shopdaily.presentation.common.components.feedback.FeedbackLabel
import com.ecommerce.shopdaily.presentation.common.components.screen.BottomPaddingColumn
import com.ecommerce.shopdaily.presentation.common.components.screen.Loading
import com.ecommerce.shopdaily.presentation.common.components.screen.ScreenTitle
import com.ecommerce.shopdaily.presentation.common.util.feedback.FeedbackType
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.favorites.components.FavoriteProduct

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Favorites(
    mainViewModel: MainViewModel
) {
    val favoritesState = mainViewModel.favoritesState

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            AppBar(
                isBackEnabled = false,
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            BottomPaddingColumn {
                ScreenTitle(title = "Favorites")
                if (favoritesState.isLoading) {
                    Loading(modifier = Modifier.fillMaxSize())
                } else {
                    if (favoritesState.error != null && favoritesState.error.isNotEmpty()) {
                        FeedbackLabel(
                            modifier = Modifier.fillMaxSize(),
                            FeedbackType.Error(favoritesState.error)
                        )
                    } else {
                        if (favoritesState.favorites != null) {
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentPadding = PaddingValues(10.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                items(favoritesState.favorites) { favorite ->
                                    FavoriteProduct(favorite = favorite)
                                }
                            }
                        } else {
                            FeedbackLabel(
                                modifier = Modifier.fillMaxSize(),
                                FeedbackType.Info("There is no favorites")
                            )
                        }
                    }
                }
            }
        })
}