package com.ecommerce.shopdaily.data.remote.dto.category

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class CategoryDtoTest {
    @Test
    fun `products list should not be null or empty`() {
        val productDto = ProductDto(
            brand = "Nike",
            category = "shoes",
            description = "Cool shoes",
            discountPercentage = 0.0,
            id = 1,
            images = listOf("https://example.com/image.jpg"),
            price = 100,
            rating = 4.5,
            stock = 10,
            thumbnail = "https://example.com/thumbnail.jpg",
            title = "Cool Shoes"
        )
        val categoryDto = CategoryDto(
            limit = 10,
            productDtos = listOf(productDto),
            skip = 0,
            total = 1
        )

        val products = categoryDto.productDtos

        assertThat(products).isNotNull()
        assertThat(products).isNotEmpty()
    }

    @Test
    fun `total should be greater than or equal to zero`() {
        val categoryDto = CategoryDto(
            limit = 10,
            productDtos = emptyList(),
            skip = 0,
            total = 1
        )

        val total = categoryDto.total

        assertThat(total).isAtLeast(0)
    }
}