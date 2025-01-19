package com.ecommerce.shopdaily.data.db.entities

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ProductDtoEntityTest {

    private lateinit var product: ProductEntity

    @Before
    fun setup() {
        product = ProductEntity(
            productId = 1234,
            image = "https://example.com/image.png",
            title = "Example Product",
            subtitle = "An example product",
            price = 1000,
            discount = 0.1,
            rating = 4.5,
            description = "This is an example product",
            images = listOf("https://example.com/image1.png", "https://example.com/image2.png"),
            category = "Example Category"
        )
    }

    @Test
    fun testProductEntity_primaryKey() {
        assertThat(product.id).isNull()
    }

    @Test
    fun testProductEntity_fields() {
        assertThat(product.productId).isEqualTo(1234)
        assertThat(product.image).isEqualTo("https://example.com/image.png")
        assertThat(product.title).isEqualTo("Example Product")
        assertThat(product.subtitle).isEqualTo("An example product")
        assertThat(product.price).isEqualTo(1000)
        assertThat(product.discount).isWithin(0.01).of(0.1)
        assertThat(product.rating).isWithin(0.01).of(4.5)
        assertThat(product.description).isEqualTo("This is an example product")
        assertThat(product.images).containsExactly(
            "https://example.com/image1.png",
            "https://example.com/image2.png"
        )
        assertThat(product.category).isEqualTo("Example Category")
    }

    @Test
    fun testProductEntity_equals() {
        val sameProduct = ProductEntity(
            productId = 1234,
            image = "https://example.com/image.png",
            title = "Example Product",
            subtitle = "An example product",
            price = 1000,
            discount = 0.1,
            rating = 4.5,
            description = "This is an example product",
            images = listOf("https://example.com/image1.png", "https://example.com/image2.png"),
            category = "Example Category"
        )
        val differentProduct = ProductEntity(
            productId = 5678,
            image = "https://example.com/otherimage.png",
            title = "Different Product",
            subtitle = "A different product",
            price = 2000,
            discount = 0.2,
            rating = 3.5,
            description = "This is a different product",
            images = listOf(
                "https://example.com/otherimage1.png",
                "https://example.com/otherimage2.png"
            ),
            category = "Different Category"
        )

        assertThat(product).isEqualTo(sameProduct)
        assertThat(product).isNotEqualTo(differentProduct)
    }
}
