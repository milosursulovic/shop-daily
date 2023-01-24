package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.bottom_navigation

import com.ecommerce.shopdaily.R

data class NavIcon(
    val label: String,
    val selectedIcon: Int,
    val selectedIconDark: Int,
    val unselectedIcon: Int,
    val unselectedIconDark: Int,
    val destination: String
)

val navigationIcons = listOf(
    NavIcon(
        label = "Home",
        selectedIcon = R.drawable.home_selected_light,
        unselectedIcon = R.drawable.home_unselected_light,
        selectedIconDark = R.drawable.home_selected_dark,
        unselectedIconDark = R.drawable.home_unselected_dark,
        destination = MainScreen.MainPage.route
    ),
    NavIcon(
        label = "Shop",
        selectedIcon = R.drawable.shop_selected_light,
        unselectedIcon = R.drawable.shop_unselected_light,
        selectedIconDark = R.drawable.shop_selected_dark,
        unselectedIconDark = R.drawable.shop_unselected_dark,
        destination = MainScreen.ShopPage.route
    ),
    NavIcon(
        label = "Bag",
        selectedIcon = R.drawable.bag_selected_light,
        unselectedIcon = R.drawable.bag_unselected_light,
        selectedIconDark = R.drawable.bag_selected_dark,
        unselectedIconDark = R.drawable.bag_unselected_dark,
        destination = MainScreen.BagPage.route
    ),
    NavIcon(
        label = "Favorites",
        selectedIcon = R.drawable.favorites_selected_light,
        unselectedIcon = R.drawable.favorites_unselected_light,
        selectedIconDark = R.drawable.favorites_selected_dark,
        unselectedIconDark = R.drawable.favorites_unselected_dark,
        destination = MainScreen.FavoritesPage.route
    ),
    NavIcon(
        label = "Profile",
        selectedIcon = R.drawable.profile_selected_light,
        unselectedIcon = R.drawable.profile_unselected_light,
        selectedIconDark = R.drawable.profile_selected_dark,
        unselectedIconDark = R.drawable.profile_unselected_dark,
        destination = MainScreen.ProfilePage.route
    )
)