package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.mappers.product.toProduct
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetFavoritesUseCaseTest {
    @Mock
    private lateinit var mockRepository: DummyJsonRepository

    private lateinit var useCase: GetFavoritesUseCase

    @Before
    fun setUp() {
        useCase = GetFavoritesUseCase(mockRepository)
    }

    @Test
    fun `invoke should emit Success resource when getFavorites is successful`() =
        runBlocking {
            val favorites = listOf(
                ProductEntity(
                    productId = 1,
                    image = "https://example.com/images/product1.jpg",
                    title = "Example Product 1",
                    subtitle = "Lorem ipsum dolor sit amet",
                    price = 100,
                    discount = 0.2,
                    rating = 4.5,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam euismod felis id sapien congue, a malesuada justo finibus.",
                    images = listOf(
                        "https://example.com/images/product1-1.jpg",
                        "https://example.com/images/product1-2.jpg",
                        "https://example.com/images/product1-3.jpg"
                    ),
                    category = "Electronics"
                )
            )
            `when`(mockRepository.getFavorites()).thenReturn(favorites)
            val expectedResource = Resource.Success(favorites.map { it.toProduct() })

            var actualResource: Resource.Success<List<Product>>? = null

            useCase().collect { result ->
                if (result is Resource.Success) actualResource = result
            }

            assertThat(actualResource?.data).isEqualTo(expectedResource.data)
        }

    @Test
    fun `invoke should emit Error resource when getFavorites is empty`() =
        runBlocking {
            val favorites = emptyList<ProductEntity>()
            `when`(mockRepository.getFavorites()).thenReturn(favorites)
            val expectedResource = Resource.Error<Nothing>("")

            var actualResource: Resource.Error<List<Product>>? = null

            useCase().collect { result ->
                if (result is Resource.Error) actualResource = result
            }

            assertThat(actualResource?.message).isEqualTo(expectedResource.message)
        }

    @Test
    fun `invoke should emit Error resource when getFavorites throws an exception`() =
        runBlocking {
            `when`(mockRepository.getFavorites()).thenThrow(RuntimeException("Test exception message"))
            val expectedResource = Resource.Error<Nothing>("Test exception message")

            var actualResource: Resource.Error<List<Product>>? = null

            useCase().collect { result ->
                if (result is Resource.Error) actualResource = result
            }

            assertThat(actualResource?.message).isEqualTo(expectedResource.message)
        }
}