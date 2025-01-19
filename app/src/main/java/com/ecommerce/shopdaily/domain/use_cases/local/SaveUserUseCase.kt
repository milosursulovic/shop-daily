package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.mappers.user.toUserEntity
import com.ecommerce.shopdaily.domain.model.login.User
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveUserUseCase(
    private val repository: DummyJsonRepository
) {
    operator fun invoke(user: User): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            repository.saveUser(user.toUserEntity())
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}