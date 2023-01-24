package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area

import java.io.Serializable

sealed class ProductType : Serializable {
    object New : ProductType()
    object Sale : ProductType()
}
