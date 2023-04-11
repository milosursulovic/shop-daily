package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.mappers.user.toUser
import com.ecommerce.shopdaily.domain.model.login.User
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
class GetSavedUserUseCaseTest {
    @Mock
    private lateinit var mockRepository: DummyJsonRepository

    private lateinit var useCase: GetSavedUserUseCase

    @Before
    fun setUp() {
        useCase = GetSavedUserUseCase(mockRepository)
    }

    @Test
    fun `invoke should emit Success resource when getSavedUser is successful`() =
        runBlocking {
            val savedUser = listOf(
                UserEntity(
                    id = 1,
                    username = "johndoe",
                    email = "johndoe@example.com",
                    firstName = "John",
                    lastName = "Doe",
                    image = "https://example.com/images/johndoe.jpg",
                    token = "abc123xyz456"
                )
            )
            `when`(mockRepository.getSavedUser()).thenReturn(savedUser)
            val expectedResource = Resource.Success(savedUser[0].toUser())

            var actualResource: Resource.Success<User>? = null

            useCase().collect { result ->
                if (result is Resource.Success) actualResource = result
            }

            assertThat(actualResource?.data).isEqualTo(expectedResource.data)
        }

    @Test
    fun `invoke should emit Error resource when getSavedUser is empty`() =
        runBlocking {
            val savedUser = emptyList<UserEntity>()
            `when`(mockRepository.getSavedUser()).thenReturn(savedUser)
            val expectedResource = Resource.Error<Nothing>("")

            var actualResource: Resource.Error<User>? = null

            useCase().collect { result ->
                if (result is Resource.Error) actualResource = result
            }

            assertThat(actualResource?.message).isEqualTo(expectedResource.message)
        }

    @Test
    fun `invoke should emit Error resource when getSavedUser throws an exception`() =
        runBlocking {
            `when`(mockRepository.getSavedUser()).thenThrow(RuntimeException("Test exception message"))
            val expectedResource = Resource.Error<Nothing>("Test exception message")

            var actualResource: Resource.Error<User>? = null

            useCase().collect { result ->
                if (result is Resource.Error) actualResource = result
            }

            assertThat(actualResource?.message).isEqualTo(expectedResource.message)
        }
}