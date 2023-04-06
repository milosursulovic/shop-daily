package com.ecommerce.shopdaily.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShopDailyDaoTest {
    private lateinit var database: ShopDailyDatabase
    private lateinit var dao: ShopDailyDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, ShopDailyDatabase::class.java).build()
        dao = database.dao
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testSaveUserAndGetUser() = runBlocking {
        val user = UserEntity(
            username = "test_user",
            email = "test_email",
            firstName = "test_first_name",
            lastName = "test_last_name",
            image = "test_image",
            token = "test_token"
        )
        val result = dao.saveUser(user)
        assertThat(result).isGreaterThan(0)

        val savedUser = dao.getUser().firstOrNull()
        assertThat(savedUser).isNotNull()
        assertThat(savedUser!!.username).isEqualTo(user.username)
        assertThat(savedUser.email).isEqualTo(user.email)
        assertThat(savedUser.firstName).isEqualTo(user.firstName)
        assertThat(savedUser.lastName).isEqualTo(user.lastName)
        assertThat(savedUser.image).isEqualTo(user.image)
        assertThat(savedUser.token).isEqualTo(user.token)
    }

    @Test
    fun testSaveProductToFavoritesAndGetFavoritesAndDeleteFromFavorites() = runBlocking {
        val product = ProductEntity(
            productId = 123,
            image = "test_image",
            title = "test_title",
            subtitle = "test_subtitle",
            price = 100,
            discount = 0.2,
            rating = 4.5,
            description = "test_description",
            images = listOf("test_image_1", "test_image_2"),
            category = "test_category"
        )
        val result = dao.saveProductToFavorites(product)
        assertThat(result).isGreaterThan(0)

        val savedProduct = dao.getFavorites().firstOrNull()
        assertThat(savedProduct).isNotNull()
        assertThat(savedProduct!!.productId).isEqualTo(product.productId)
        assertThat(savedProduct.image).isEqualTo(product.image)
        assertThat(savedProduct.title).isEqualTo(product.title)
        assertThat(savedProduct.subtitle).isEqualTo(product.subtitle)
        assertThat(savedProduct.price).isEqualTo(product.price)
        assertThat(savedProduct.discount).isEqualTo(product.discount)
        assertThat(savedProduct.rating).isEqualTo(product.rating)
        assertThat(savedProduct.description).isEqualTo(product.description)
        assertThat(savedProduct.images).isEqualTo(product.images)
        assertThat(savedProduct.category).isEqualTo(product.category)

        dao.deleteFromFavorites(product.productId, product.category)
        val deletedProduct = dao.getFavorites().firstOrNull()
        assertThat(deletedProduct).isNull()
    }
}
