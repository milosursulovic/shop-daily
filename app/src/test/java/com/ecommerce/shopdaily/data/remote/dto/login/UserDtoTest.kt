package com.ecommerce.shopdaily.data.remote.dto.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserDtoTest {
    @Test
    fun `user properties should match the provided values`() {
        val userDto = UserDto(
            email = "user@example.com",
            firstName = "John",
            gender = "male",
            id = 1,
            image = "https://example.com/user.jpg",
            lastName = "Doe",
            token = "abc123",
            username = "johndoe"
        )

        val actualEmail = userDto.email
        val actualFirstName = userDto.firstName
        val actualGender = userDto.gender
        val actualId = userDto.id
        val actualImage = userDto.image
        val actualLastName = userDto.lastName
        val actualToken = userDto.token
        val actualUsername = userDto.username

        assertThat(actualEmail).isEqualTo("user@example.com")
        assertThat(actualFirstName).isEqualTo("John")
        assertThat(actualGender).isEqualTo("male")
        assertThat(actualId).isEqualTo(1)
        assertThat(actualImage).isEqualTo("https://example.com/user.jpg")
        assertThat(actualLastName).isEqualTo("Doe")
        assertThat(actualToken).isEqualTo("abc123")
        assertThat(actualUsername).isEqualTo("johndoe")
    }
}