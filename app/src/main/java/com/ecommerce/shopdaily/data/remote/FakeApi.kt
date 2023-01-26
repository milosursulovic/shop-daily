package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants

class FakeApi {
    fun getDummyProducts() = listOf(
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            emptyList()
        ),
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            emptyList()
        ),
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            emptyList()
        ),
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            emptyList()
        ),
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            emptyList()
        )
    )
}