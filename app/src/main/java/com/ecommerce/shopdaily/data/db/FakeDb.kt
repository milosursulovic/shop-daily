package com.ecommerce.shopdaily.data.db

import com.ecommerce.shopdaily.R
import com.ecommerce.shopdaily.domain.model.Product
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants

class FakeDb {
    fun getFavorites() = listOf(
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.New
        ),
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.New
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.Sale
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.Sale
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.Sale
        )
    )
}