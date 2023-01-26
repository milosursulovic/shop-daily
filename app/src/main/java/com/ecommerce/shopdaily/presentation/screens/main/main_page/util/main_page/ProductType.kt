package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_page

sealed class ProductType {
    object New : ProductType()
    object Sale : ProductType()
}
