package com.ecommerce.shopdaily.data.db.entities

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class UserEntityTest {

    private lateinit var user: UserEntity

    @Before
    fun setUp() {
        user = UserEntity(
            username = "johndoe",
            email = "johndoe@example.com",
            firstName = "John",
            lastName = "Doe",
            image = "https://example.com/johndoe.jpg",
            token = "abc123"
        )
    }

    @Test
    fun testUserEntity_primaryKey() {
        assertThat(user.id).isNull()
    }

    @Test
    fun testUserEntity_fields() {
        assertThat(user.username).isEqualTo("johndoe")
        assertThat(user.email).isEqualTo("johndoe@example.com")
        assertThat(user.firstName).isEqualTo("John")
        assertThat(user.lastName).isEqualTo("Doe")
        assertThat(user.image).isEqualTo("https://example.com/johndoe.jpg")
        assertThat(user.token).isEqualTo("abc123")
    }

    @Test
    fun testUserEntity_equals() {
        val sameUser = UserEntity(
            username = "johndoe",
            email = "johndoe@example.com",
            firstName = "John",
            lastName = "Doe",
            image = "https://example.com/johndoe.jpg",
            token = "abc123"
        )
        val differentUser = UserEntity(
            username = "janedoe",
            email = "janedoe@example.com",
            firstName = "Jane",
            lastName = "Doe",
            image = "https://example.com/janedoe.jpg",
            token = "def456"
        )

        assertThat(user).isEqualTo(sameUser)
        assertThat(user).isNotEqualTo(differentUser)
    }
}
