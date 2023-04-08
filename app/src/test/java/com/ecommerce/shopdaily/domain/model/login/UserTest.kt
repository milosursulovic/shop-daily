package com.ecommerce.shopdaily.domain.model.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserTest {
    @Test
    fun `test that User has correct properties`() {
        val user = User(
            "testuser", "testuser@example.com", "Test", "User",
            "http://example.com/testuser.jpg", "testtoken"
        )

        assertThat(user.username).isEqualTo("testuser")
        assertThat(user.email).isEqualTo("testuser@example.com")
        assertThat(user.firstName).isEqualTo("Test")
        assertThat(user.lastName).isEqualTo("User")
        assertThat(user.image).isEqualTo("http://example.com/testuser.jpg")
        assertThat(user.token).isEqualTo("testtoken")
    }
}