package com.ecommerce.shopdaily.data.mappers.user

import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.domain.model.login.User
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserMapperTest {
    @Test
    fun `toUserEntity converts User to UserEntity correctly`() {
        val user = User(
            username = "test_user",
            email = "test_user@example.com",
            firstName = "Test",
            lastName = "User",
            image = "https://example.com/profile_image.png",
            token = "some_token"
        )

        val userEntity = user.toUserEntity()

        assertThat(userEntity.username).isEqualTo(user.username)
        assertThat(userEntity.email).isEqualTo(user.email)
        assertThat(userEntity.firstName).isEqualTo(user.firstName)
        assertThat(userEntity.lastName).isEqualTo(user.lastName)
        assertThat(userEntity.image).isEqualTo(user.image)
        assertThat(userEntity.token).isEqualTo(user.token)
    }

    @Test
    fun `toUser converts UserDto to User correctly`() {
        val userDto = UserDto(
            email = "test_user@example.com",
            firstName = "Test",
            gender = "Male",
            id = 123,
            image = "https://example.com/profile_image.png",
            lastName = "User",
            token = "some_token",
            username = "test_user"
        )

        val user = userDto.toUser()

        assertThat(user.username).isEqualTo(userDto.username)
        assertThat(user.email).isEqualTo(userDto.email)
        assertThat(user.firstName).isEqualTo(userDto.firstName)
        assertThat(user.lastName).isEqualTo(userDto.lastName)
        assertThat(user.image).isEqualTo(userDto.image)
        assertThat(user.token).isEqualTo(userDto.token)
    }

    @Test
    fun `toUser converts UserEntity to User correctly`() {
        val userEntity = UserEntity(
            id = 123,
            username = "test_user",
            email = "test_user@example.com",
            firstName = "Test",
            lastName = "User",
            image = "https://example.com/profile_image.png",
            token = "some_token"
        )

        val user = userEntity.toUser()

        assertThat(user.username).isEqualTo(userEntity.username)
        assertThat(user.email).isEqualTo(userEntity.email)
        assertThat(user.firstName).isEqualTo(userEntity.firstName)
        assertThat(user.lastName).isEqualTo(userEntity.lastName)
        assertThat(user.image).isEqualTo(userEntity.image)
        assertThat(user.token).isEqualTo(userEntity.token)
    }
}