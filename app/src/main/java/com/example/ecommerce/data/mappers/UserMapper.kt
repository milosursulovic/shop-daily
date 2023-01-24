package com.example.ecommerce.data.mappers

import com.example.ecommerce.data.db.entities.UserEntity
import com.example.ecommerce.data.remote.dto.login.UserDto
import com.example.ecommerce.domain.model.login.User

fun User.toUserEntity(): UserEntity =
    UserEntity(0, username, email, firstName, lastName, image, token)

fun UserDto.toUser(): User = User(username, email, firstName, lastName, image, token)

fun UserEntity.toUser(): User = User(username, email, firstName, lastName, image, token)