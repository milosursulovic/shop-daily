package com.ecommerce.shopdaily.data.mappers.product

import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.remote.dto.product.ProductDto
import com.ecommerce.shopdaily.domain.model.product.Product

fun ProductDto.toProduct(): Product =
    Product(
        productId = id,
        image = thumbnail,
        title = title,
        subtitle = brand,
        price = price,
        discount = discountPercentage,
        rating = rating,
        description = description,
        images = images,
        category = category
    )

fun Product.toProductEntity(): ProductEntity =
    ProductEntity(
        0,
        productId,
        image,
        title,
        subtitle,
        price,
        discount,
        rating,
        description,
        images,
        category
    )

fun ProductEntity.toProduct(): Product =
    Product(
        productId,
        image,
        title,
        subtitle,
        price,
        discount,
        rating,
        description,
        images,
        category
    )