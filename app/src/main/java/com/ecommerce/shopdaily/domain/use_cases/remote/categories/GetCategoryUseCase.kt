package com.ecommerce.shopdaily.domain.use_cases.remote.categories

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.mappers.category.toCategory
import com.ecommerce.shopdaily.domain.model.category.Category
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class GetCategoryUseCase(
    private val repository: DummyJsonRepository
) {
    suspend operator fun invoke(
        token: String,
        categoryId: String,
        name: String
    ): Flow<Resource<Category>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getCategory(token, categoryId)
            if (response.isSuccessful) {
                response.body()?.let { categoryDto ->
                    val category = categoryDto.toCategory().copy(
                        categoryId = categoryId,
                        name = name
                    )
                    emit(Resource.Success(category))
                }
            } else {
                response.errorBody()?.let {
                    val jsonObj = JSONObject(it.string())
                    val errorMsg = jsonObj.getString("message")
                    emit(Resource.Error(errorMsg))
                } ?: emit(Resource.Error("Something went wrong!"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}