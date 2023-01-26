package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants

class FakeApi {
    fun getDummyProducts() = listOf(
        Product(
            productId = 1,
            image =  "",
            title = "T-Shirt Sailing",
            subtitle = "Mango Boy",
            price = 10,
            discount = 2.2,
            rating = 0.0,
            description = Constants.PRODUCT_DESCRIPTION,
            images = emptyList(),
            category = ""
        ),
        Product(
            productId = 1,
            image =  "",
            title = "T-Shirt Sailing",
            subtitle = "Mango Boy",
            price = 10,
            discount = 2.2,
            rating = 0.0,
            description = Constants.PRODUCT_DESCRIPTION,
            images = emptyList(),
            category = ""
        ),
        Product(
            productId = 1,
            image =  "",
            title = "T-Shirt Sailing",
            subtitle = "Mango Boy",
            price = 10,
            discount = 2.2,
            rating = 0.0,
            description = Constants.PRODUCT_DESCRIPTION,
            images = emptyList(),
            category = ""
        ),
        Product(
            productId = 1,
            image =  "",
            title = "T-Shirt Sailing",
            subtitle = "Mango Boy",
            price = 10,
            discount = 2.2,
            rating = 0.0,
            description = Constants.PRODUCT_DESCRIPTION,
            images = emptyList(),
            category = ""
        ),
        Product(
            productId = 1,
            image =  "",
            title = "T-Shirt Sailing",
            subtitle = "Mango Boy",
            price = 10,
            discount = 2.2,
            rating = 0.0,
            description = Constants.PRODUCT_DESCRIPTION,
            images = emptyList(),
            category = ""
        )
    )
}