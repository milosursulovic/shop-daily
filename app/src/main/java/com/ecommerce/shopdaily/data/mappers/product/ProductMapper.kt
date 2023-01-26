package com.ecommerce.shopdaily.data.mappers.product

import com.ecommerce.shopdaily.data.remote.dto.product.ProductDto
import com.ecommerce.shopdaily.domain.model.product.Product

fun ProductDto.toProduct(): Product =
    Product(
        image = thumbnail,
        title = title,
        subtitle = brand,
        price = price,
        discount = discountPercentage,
        rating = rating,
        description = description,
        images = images
    )