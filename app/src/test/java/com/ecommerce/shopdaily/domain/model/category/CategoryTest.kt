package com.ecommerce.shopdaily.domain.model.category

import com.ecommerce.shopdaily.domain.model.product.Product
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CategoryTest {
    @Test
    fun `test that category has correct properties`() {
        val products = listOf(
            Product(
                1, "image1.jpg", "Product 1", "Subtitle 1", 100, 0.1, 4.0, "Description 1",
                listOf("image1.jpg", "image2.jpg"), "Category 1"
            ),
            Product(
                2, "image2.jpg", "Product 2", "Subtitle 2", 200, 0.2, 3.5, "Description 2",
                listOf("image1.jpg", "image2.jpg"), "Category 1"
            )
        )
        val category = Category("1", "Category 1", 500, products, 0, 2)

        assertThat(category.categoryId).isEqualTo("1")
        assertThat(category.name).isEqualTo("Category 1")
        assertThat(category.limit).isEqualTo(500)
        assertThat(category.products).containsExactlyElementsIn(products)
        assertThat(category.skip).isEqualTo(0)
        assertThat(category.total).isEqualTo(2)
    }
}