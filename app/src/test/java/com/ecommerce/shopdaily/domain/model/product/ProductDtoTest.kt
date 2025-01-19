package com.ecommerce.shopdaily.domain.model.product

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ProductDtoTest {
    @Test
    fun `test that Product has correct properties`() {
        val product = Product(
            1, "http://example.com/image.jpg", "Product 1", "Subtitle 1",
            100, 0.1, 4.0, "Description 1", listOf("http://example.com/image.jpg"),
            "Category 1"
        )

        assertThat(product.productId).isEqualTo(1)
        assertThat(product.image).isEqualTo("http://example.com/image.jpg")
        assertThat(product.title).isEqualTo("Product 1")
        assertThat(product.subtitle).isEqualTo("Subtitle 1")
        assertThat(product.price).isEqualTo(100)
        assertThat(product.discount).isEqualTo(0.1)
        assertThat(product.rating).isEqualTo(4.0)
        assertThat(product.description).isEqualTo("Description 1")
        assertThat(product.images).containsExactly("http://example.com/image.jpg")
        assertThat(product.category).isEqualTo("Category 1")
    }
}