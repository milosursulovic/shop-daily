package com.ecommerce.shopdaily.domain.model.category

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ShopCategoryTest {
    @Test
    fun `test that ShopCategory has correct properties`() {
        val shopCategory = ShopCategory("1", "Category 1")

        assertThat(shopCategory.categoryId).isEqualTo("1")
        assertThat(shopCategory.name).isEqualTo("Category 1")
    }
}