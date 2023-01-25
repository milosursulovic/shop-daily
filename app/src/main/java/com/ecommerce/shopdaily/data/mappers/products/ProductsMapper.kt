package com.ecommerce.shopdaily.data.mappers.products

import com.ecommerce.shopdaily.data.remote.dto.products.ProductDto
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType

fun ProductDto.toProduct(): Product =
    Product(
        image = thumbnail,
        title = title,
        subtitle = brand,
        price = price,
        discount = discountPercentage,
        rating = rating,
        description = description,
        productType = ProductType.New
    )