package com.example.ecommerce.presentation.pages.main_page.components.bottom_navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.pages.main_page.util.bottom_navigation.NavIcon
import com.example.ecommerce.presentation.ui.theme.MainNavGray

@Composable
fun MainBottomNavigation() {
    val navigationIcons = listOf(
        NavIcon(label = "Home", icon = Icons.Outlined.Home),
        NavIcon(label = "Shop", icon = Icons.Outlined.ShoppingCart),
        NavIcon(label = "Bag", icon = Icons.Outlined.Place),
        NavIcon(label = "Favorites", icon = Icons.Outlined.FavoriteBorder),
        NavIcon(label = "Profile", icon = Icons.Outlined.Person)
    )
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .border(BorderStroke(1.dp, MainNavGray)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        navigationIcons.forEach { icon ->
            BottomNavIcon(navIcon = icon)
        }
    }
}