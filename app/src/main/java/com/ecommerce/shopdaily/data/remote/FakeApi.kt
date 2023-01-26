package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants

class FakeApi {
    fun getNewProducts() = listOf(
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
            emptyList()
        )
    )

    fun getSaleProducts() = listOf(
        Product(
            "",
            "T-Shirt Sailing",
            "Mango Boy",
            10,
            2.2,
            0.0,
            Constants.PRODUCT_DESCRIPTION,
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
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
            ProductType.New,
            emptyList()
        )
    )
}