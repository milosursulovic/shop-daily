package com.example.ecommerce.domain.use_cases.local

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.mappers.toUserEntity
import com.example.ecommerce.domain.model.login.User
import com.example.ecommerce.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveUserUseCase(
    private val repository: DummyJsonRepository
) {
    suspend operator fun invoke(user: User): Flow<Resource<Long>> = flow {
        emit(Resource.Loading())
        try {
            val result = repository.saveUser(user.toUserEntity())
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error("[ERROR]: ${e.localizedMessage}"))
        }
    }
}