package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.data.remote.dto.login.request.LoginRequestBody
import com.ecommerce.shopdaily.data.remote.dto.product.ProductDto
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class DummyJsonServiceTest {
    @Mock
    lateinit var dummyJsonService: DummyJsonService

    @Test
    fun `test login`() = runBlocking {
        val userDto = UserDto(
            "test@test.com",
            "John",
            "Male",
            1,
            "https://example.com/image.jpg",
            "Doe",
            "token",
            "johndoe"
        )
        val loginRequestBody = LoginRequestBody("johndoe", "password")
        val response = Response.success(userDto)
        `when`(dummyJsonService.login(loginRequestBody)).thenReturn(response)
        val result = dummyJsonService.login(loginRequestBody)
        assertThat(response).isEqualTo(result)
    }

    @Test
    fun `test get categories`() = runBlocking {
        val categories = listOf("Category 1", "Category 2", "Category 3")
        val response = Response.success(categories)
        val token = "token"
        `when`(dummyJsonService.getCategories(token)).thenReturn(response)
        val result = dummyJsonService.getCategories(token)
        assertThat(response).isEqualTo(result)
    }

    @Test
    fun `test get category`() = runBlocking {
        val categoryDto = CategoryDto(10, emptyList(), 0, 0)
        val categoryId = "category-1"
        val response = Response.success(categoryDto)
        val token = "token"
        `when`(dummyJsonService.getCategory(token, categoryId)).thenReturn(response)
        val result = dummyJsonService.getCategory(token, categoryId)
        assertThat(response).isEqualTo(result)
    }

    @Test
    fun `test get products`() = runBlocking {
        val productDto = ProductDto(
            "Brand",
            "Category",
            "Description",
            0.0,
            1,
            emptyList(),
            100,
            0.0,
            10,
            "https://example.com/thumbnail.jpg",
            "Title"
        )
        val categoryDto = CategoryDto(10, listOf(productDto), 0, 1)
        val response = Response.success(categoryDto)
        val token = "token"
        val limit = 10
        val skip = 0
        `when`(dummyJsonService.getProducts(token, limit, skip)).thenReturn(response)
        val result = dummyJsonService.getProducts(token, limit, skip)
        assertThat(response).isEqualTo(result)
    }
}
