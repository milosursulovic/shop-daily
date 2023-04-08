package com.ecommerce.shopdaily.data.repository

import com.ecommerce.shopdaily.data.db.ShopDailyDao
import com.ecommerce.shopdaily.data.remote.DummyJsonService
import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.data.remote.dto.login.request.LoginRequestBody
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class DummyJsonRepositoryTest {

    private lateinit var repository: DummyJsonRepositoryImpl

    @Mock
    private lateinit var mockApi: DummyJsonService

    @Mock
    private lateinit var mockDao: ShopDailyDao

    @Before
    fun setup() {
        repository = DummyJsonRepositoryImpl(mockApi, mockDao)
    }

    @Test
    fun `test login function`() = runBlocking {
        val userDto =
            UserDto("test@gmail.com", "Test", "Male", 1, "", "User", "1234567890", "test_user")
        val username = "test_user"
        val password = "1234567890"
        `when`(mockApi.login(LoginRequestBody(username, password))).thenReturn(
            Response.success(
                userDto
            )
        )

        val response = repository.login(username, password)

        assertThat(response.body()).isEqualTo(userDto)
    }

    @Test
    fun `test getCategories function`() = runBlocking {
        val token = "token"
        val categories = listOf("Electronics", "Clothing", "Food")

        `when`(mockApi.getCategories(token)).thenReturn(Response.success(categories))

        val response = mockApi.getCategories(token)

        assertThat(response.body()).isEqualTo(categories)
    }

    @Test
    fun `test getCategory function`() = runBlocking {
        val token = "token"
        val categoryDto = CategoryDto(20, emptyList(), 0, 0)
        `when`(mockApi.getCategory(token, "123")).thenReturn(Response.success(categoryDto))

        val response = repository.getCategory(token, "123")

        assertThat(response.body()).isEqualTo(categoryDto)
    }

    @Test
    fun `test getProducts function`() = runBlocking {
        val token = "token"
        val categoryDto = CategoryDto(20, emptyList(), 0, 0)
        `when`(mockApi.getProducts(token, skip = 0)).thenReturn(Response.success(categoryDto))

        val response = repository.getProducts(token, 0)

        assertThat(response.body()).isEqualTo(categoryDto)
    }
}