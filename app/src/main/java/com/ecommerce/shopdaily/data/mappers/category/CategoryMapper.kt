package com.ecommerce.shopdaily.data.mappers.category

import com.ecommerce.shopdaily.data.mappers.product.toProduct
import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.domain.model.category.Category

fun CategoryDto.toCategory(): Category =
    Category(
        "",
        "",
        limit,
        products.map { it.toProduct() },
        skip,
        total
    )