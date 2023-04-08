package com.ecommerce.shopdaily.data.repository

import com.ecommerce.shopdaily.data.db.ShopDailyDao
import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.db.entities.UserEntity
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
import org.mockito.Mockito.*
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

    @Test
    fun `getSavedUser should return list of UserEntity`() = runBlocking {
        val mockUserList = listOf(
            UserEntity(
                id = 1,
                username = "john_doe",
                email = "john.doe@example.com",
                firstName = "John",
                lastName = "Doe",
                image = "https://example.com/john_doe.jpg",
                token = "token123"
            ),
            UserEntity(
                id = 2,
                username = "jane_doe",
                email = "jane.doe@example.com",
                firstName = "Jane",
                lastName = "Doe",
                image = "https://example.com/jane_doe.jpg",
                token = "token456"
            )
        )
        `when`(mockDao.getUser()).thenReturn(mockUserList)

        val result = mockDao.getUser()

        assertThat(result).isEqualTo(mockUserList)
    }

    @Test
    fun `saveUser should return the ID of the saved user`() = runBlocking {
        val mockUserId = 1L
        val user = UserEntity(
            username = "john_doe",
            email = "john.doe@example.com",
            firstName = "John",
            lastName = "Doe",
            image = "https://example.com/john_doe.jpg",
            token = "token123"
        )

        `when`(mockDao.saveUser(user)).thenReturn(mockUserId)

        val result = mockDao.saveUser(user)

        assertThat(result).isEqualTo(mockUserId)
    }

    @Test
    fun `saveProductToFavorites should return the ID of the saved product`() = runBlocking {
        val mockProductId = 1L
        val product = ProductEntity(
            productId = 12345,
            image = "https://example.com/image.jpg",
            title = "Product Title",
            subtitle = "Product Subtitle",
            price = 999,
            discount = 0.2,
            rating = 4.8,
            description = "This is a dummy product description.",
            images = listOf("https://example.com/image1.jpg", "https://example.com/image2.jpg"),
            category = "Electronics"
        )


        `when`(mockDao.saveProductToFavorites(product)).thenReturn(mockProductId)

        val result = mockDao.saveProductToFavorites(product)

        assertThat(result).isEqualTo(mockProductId)
    }

    @Test
    fun `test getFavorites`() = runBlocking {
        val products = listOf(
            ProductEntity(
                productId = 1,
                image = "img1.jpg",
                title = "Product 1",
                subtitle = "Subtitle 1",
                price = 100,
                discount = 0.1,
                rating = 4.5,
                description = "Product 1 description",
                images = listOf("img1.jpg", "img2.jpg"),
                category = "Category 1"
            ),
            ProductEntity(
                productId = 2,
                image = "img2.jpg",
                title = "Product 2",
                subtitle = "Subtitle 2",
                price = 200,
                discount = 0.2,
                rating = 3.5,
                description = "Product 2 description",
                images = listOf("img3.jpg", "img4.jpg"),
                category = "Category 2"
            )
        )
        `when`(mockDao.getFavorites()).thenReturn(products)
        val result = mockDao.getFavorites()
        assertThat(result).isEqualTo(products)
    }

    @Test
    fun `test deleteFromFavorites`() = runBlocking {
        val productId = 1
        val category = "Category 1"
        mockDao.deleteFromFavorites(productId, category)
        verify(mockDao, times(1)).deleteFromFavorites(productId, category)
    }
}