package com.ecommerce.shopdaily.data.db

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ConvertersTest {
    private val converters = Converters()

    @Test
    fun `fromList converts list of strings to a semicolon separated string`() {
        val list = listOf("one", "two", "three")
        val expected = "one;two;three"
        val actual = converters.fromList(list)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `toList converts a semicolon separated string to a list of strings`() {
        val str = "one;two;three"
        val expected = listOf("one", "two", "three")
        val actual = converters.toList(str)
        assertThat(actual).isEqualTo(expected)
    }
}
