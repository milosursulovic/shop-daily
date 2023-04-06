package com.ecommerce.shopdaily.data.remote.dto.login.request

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginRequestBodyTest {
    @Test
    fun `username and password should match the provided values`() {
        // Arrange
        val username = "user@example.com"
        val password = "password123"
        val loginRequestBody = LoginRequestBody(
            username = username,
            password = password
        )

        // Act
        val actualUsername = loginRequestBody.username
        val actualPassword = loginRequestBody.password

        // Assert
        assertThat(actualUsername).isEqualTo(username)
        assertThat(actualPassword).isEqualTo(password)
    }
}