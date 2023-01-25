package com.ecommerce.shopdaily.data.mappers.categories

import com.ecommerce.shopdaily.data.mappers.products.toProduct
import com.ecommerce.shopdaily.data.remote.dto.categories.CategoryDto
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