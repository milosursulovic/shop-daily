package com.example.ecommerce.presentation.screens.main.main_page.util.main_area

sealed class ProductType {
    object New : ProductType()
    object Sale : ProductType()
}
