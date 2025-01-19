package com.ecommerce.shopdaily.data.mappers.category

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CategoryDtoTest {

    @Test
    fun `mapping CategoryDto to Category`() {
        val productDto1 = ProductDto(
            "Brand 1",
            "Category 1",
            "Description 1",
            10.0,
            1,
            listOf("image1"),
            100,
            4.0,
            10,
            "thumbnail1",
            "Title 1"
        )
        val productDto2 = ProductDto(
            "Brand 2",
            "Category 2",
            "Description 2",
            20.0,
            2,
            listOf("image2"),
            200,
            4.5,
            20,
            "thumbnail2",
            "Title 2"
        )
        val categoryDto = CategoryDto(2, listOf(productDto1, productDto2), 0, 2)

        val category = categoryDto.toCategory()

        assertThat(category.categoryId).isEqualTo("")
        assertThat(category.name).isEqualTo("")
        assertThat(category.limit).isEqualTo(2)
        assertThat(category.skip).isEqualTo(0)
        assertThat(category.total).isEqualTo(2)
        assertThat(category.products.size).isEqualTo(2)

        assertThat(category.products[0].productId).isEqualTo(1)
        assertThat(category.products[0].image).isEqualTo("thumbnail1")
        assertThat(category.products[0].title).isEqualTo("Title 1")
        assertThat(category.products[0].subtitle).isEqualTo("Brand 1")
        assertThat(category.products[0].price).isEqualTo(100)
        assertThat(category.products[0].discount).isEqualTo(10.0)
        assertThat(category.products[0].rating).isEqualTo(4.0)
        assertThat(category.products[0].description).isEqualTo("Description 1")
        assertThat(category.products[0].images).isEqualTo(listOf("image1"))
        assertThat(category.products[0].category).isEqualTo("Category 1")

        assertThat(category.products[1].productId).isEqualTo(2)
        assertThat(category.products[1].image).isEqualTo("thumbnail2")
        assertThat(category.products[1].title).isEqualTo("Title 2")
        assertThat(category.products[1].subtitle).isEqualTo("Brand 2")
        assertThat(category.products[1].price).isEqualTo(200)
        assertThat(category.products[1].discount).isEqualTo(20.0)
        assertThat(category.products[1].rating).isEqualTo(4.5)
        assertThat(category.products[1].description).isEqualTo("Description 2")
        assertThat(category.products[1].images).isEqualTo(listOf("image2"))
        assertThat(category.products[1].category).isEqualTo("Category 2")
    }
}
