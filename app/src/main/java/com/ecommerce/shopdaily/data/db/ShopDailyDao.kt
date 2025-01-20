package com.ecommerce.shopdaily.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.db.entities.UserEntity

@Dao
interface ShopDailyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserEntity): Long

    @Query("select * from login")
    suspend fun getUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProductToFavorites(product: ProductEntity): Long

    @Query("select * from favorites")
    suspend fun getFavorites(): List<ProductEntity>

    @Query("delete from favorites where productId = :productId and category = :category")
    suspend fun deleteFromFavorites(productId: Int, category: String)
}