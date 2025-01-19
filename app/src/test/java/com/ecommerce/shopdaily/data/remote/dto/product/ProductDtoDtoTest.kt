package com.ecommerce.shopdaily.data.remote.dto.product

import com.ecommerce.shopdaily.data.remote.dto.category.ProductDto
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ProductDtoDtoTest {
    @Test
    fun `product properties should match the provided values`() {
        val productDto = ProductDto(
            brand = "Apple",
            category = "Electronics",
            description = "The latest iPhone",
            discountPercentage = 0.2,
            id = 1,
            images = listOf("https://example.com/product.jpg"),
            price = 1000,
            rating = 4.5,
            stock = 10,
            thumbnail = "https://example.com/product-thumbnail.jpg",
            title = "iPhone 12"
        )

        val actualBrand = productDto.brand
        val actualCategory = productDto.category
        val actualDescription = productDto.description
        val actualDiscountPercentage = productDto.discountPercentage
        val actualId = productDto.id
        val actualImages = productDto.images
        val actualPrice = productDto.price
        val actualRating = productDto.rating
        val actualStock = productDto.stock
        val actualThumbnail = productDto.thumbnail
        val actualTitle = productDto.title

        assertThat(actualBrand).isEqualTo("Apple")
        assertThat(actualCategory).isEqualTo("Electronics")
        assertThat(actualDescription).isEqualTo("The latest iPhone")
        assertThat(actualDiscountPercentage).isEqualTo(0.2)
        assertThat(actualId).isEqualTo(1)
        assertThat(actualImages).containsExactly("https://example.com/product.jpg")
        assertThat(actualPrice).isEqualTo(1000)
        assertThat(actualRating).isEqualTo(4.5)
        assertThat(actualStock).isEqualTo(10)
        assertThat(actualThumbnail).isEqualTo("https://example.com/product-thumbnail.jpg")
        assertThat(actualTitle).isEqualTo("iPhone 12")
    }
}