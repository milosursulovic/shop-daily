package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.mappers.toUserEntity
import com.ecommerce.shopdaily.domain.model.login.User
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
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