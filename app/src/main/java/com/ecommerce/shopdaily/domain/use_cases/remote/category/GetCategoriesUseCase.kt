package com.ecommerce.shopdaily.domain.use_cases.remote.category

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.domain.model.category.ShopCategory
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.util.*

class GetCategoriesUseCase(
    private val repository: DummyJsonRepository
) {
    operator fun invoke(token: String): Flow<Resource<List<ShopCategory>>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.getCategories(token)
            if (response.isSuccessful) {
                response.body()?.let { categories ->
                    val newCategories = mutableListOf<ShopCategory>()
                    categories.forEach { category ->
                        val newCategory = category.name.replace("-", " ").split(" ")
                            .joinToString(" ") { word ->
                                word.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(
                                        Locale.getDefault()
                                    ) else it.toString()
                                }
                            }
                        newCategories.add(ShopCategory(categoryId = category.slug, name = newCategory))
                    }
                    emit(Resource.Success(newCategories))
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