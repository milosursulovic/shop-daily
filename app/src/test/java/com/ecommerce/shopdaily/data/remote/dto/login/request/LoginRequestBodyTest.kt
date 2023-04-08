package com.ecommerce.shopdaily.data.remote.dto.login.request

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginRequestBodyTest {
    @Test
    fun `username and password should match the provided values`() {
        val username = "user@example.com"
        val password = "password123"
        val loginRequestBody = LoginRequestBody(
            username = username,
            password = password
        )

        val actualUsername = loginRequestBody.username
        val actualPassword = loginRequestBody.password

        assertThat(actualUsername).isEqualTo(username)
        assertThat(actualPassword).isEqualTo(password)
    }
}