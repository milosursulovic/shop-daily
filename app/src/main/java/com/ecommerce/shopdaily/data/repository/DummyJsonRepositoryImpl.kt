package com.ecommerce.shopdaily.data.repository

import com.ecommerce.shopdaily.data.db.ShopDailyDao
import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.remote.DummyJsonService
import com.ecommerce.shopdaily.data.remote.dto.login.LoginRequestBody
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import retrofit2.Response

class DummyJsonRepositoryImpl(
    private val api: DummyJsonService,
    private val dao: ShopDailyDao
) : DummyJsonRepository {
    override suspend fun login(username: String, password: String): Response<UserDto> = api.login(
        LoginRequestBody(username, password)
    )

    override suspend fun getSavedUser(): List<UserEntity> = dao.getUser()

    override suspend fun saveUser(user: UserEntity): Long = dao.saveUser(user)
}