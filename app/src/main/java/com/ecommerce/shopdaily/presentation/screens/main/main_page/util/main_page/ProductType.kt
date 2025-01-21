package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_page

sealed class ProductType {
    data object New : ProductType()
    data object Sale : ProductType()
}
