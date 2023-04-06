package com.ecommerce.shopdaily.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShopDailyDatabaseTest {
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
    fun testDatabaseCreation() {
        assertThat(database).isNotNull()
    }

    @Test
    fun getDao() {
        assertThat(database.dao).isNotNull()
    }

}