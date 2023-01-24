package com.ecommerce.shopdaily.data.mappers

import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.domain.model.login.User

fun User.toUserEntity(): UserEntity =
    UserEntity(0, username, email, firstName, lastName, image, token)

fun UserDto.toUser(): User = User(username, email, firstName, lastName, image, token)

fun UserEntity.toUser(): User = User(username, email, firstName, lastName, image, token)