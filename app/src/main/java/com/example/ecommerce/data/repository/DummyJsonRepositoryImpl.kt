package com.example.ecommerce.data.repository

import com.example.ecommerce.data.db.ECommerceDao
import com.example.ecommerce.data.db.entities.UserEntity
import com.example.ecommerce.data.remote.DummyJsonService
import com.example.ecommerce.data.remote.dto.login.LoginRequestBody
import com.example.ecommerce.data.remote.dto.login.UserDto
import com.example.ecommerce.domain.repository.DummyJsonRepository
import retrofit2.Response

class DummyJsonRepositoryImpl(
    private val api: DummyJsonService,
    private val dao: ECommerceDao
) : DummyJsonRepository {
    override suspend fun login(username: String, password: String): Response<UserDto> = api.login(
        LoginRequestBody(username, password)
    )

    override suspend fun getSavedUser(): List<UserEntity> = dao.getUser()

    override suspend fun saveUser(user: UserEntity): Long = dao.saveUser(user)
}