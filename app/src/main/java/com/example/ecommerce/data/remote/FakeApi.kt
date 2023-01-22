package com.example.ecommerce.data.remote

import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Category
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType
import com.example.ecommerce.presentation.screens.product.common.Constants

class FakeApi {
    fun getNewProducts() = listOf(
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
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.New
        )
    )

    fun getSaleProducts() = listOf(
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

    fun getCategories() = listOf(
        Category("New", R.drawable.category_image_1),
        Category("Clothes", R.drawable.category_image_2),
        Category("Shoes", R.drawable.category_image_3),
        Category("Accessories", R.drawable.category_image_4)
    )
}