package com.example.ecommerce.data.remote

import com.example.ecommerce.R
import com.example.ecommerce.domain.model.Product

class FakeApi {
    fun getNewProducts() = listOf(
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0
        ),
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0
        ),
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0
        ),
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0
        ),
        Product(
            R.drawable.product_card_image_1,
            "T-Shirt Sailing",
            "Mango Boy",
            10.0,
            0,
            0.0
        )
    )

    fun getSaleProducts() = listOf(
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0
        ),
        Product(
            R.drawable.product_card_image_2,
            "Evening Dress",
            "Dorothy Perkins",
            15.0,
            20,
            10.0
        )
    )
}