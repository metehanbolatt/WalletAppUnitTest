package com.metehanbolat.walletappunittest.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class FloatExtensionKtTest {

    @Test
    fun `Test float to german format without comma value`() {
        val number = 10f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("10 €")
    }

    @Test
    fun `Test float to us format without comma value`() {
        val number = 10f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("10 €")
    }

    @Test
    fun `Test float to german format with one comma value`() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("10,50 €")
    }

    @Test
    fun `Test float to US format with one comma value`() {
        val number = 10.5f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("10.50 €")
    }

    @Test
    fun `Test float format with two comma values`() {
        val number = 11.51f
        val result = number.formatToPrice(Locale.GERMAN)
        assertThat(result).isEqualTo("11,51 €")
    }

    @Test
    fun `Test float is zero format to single zero`() {
        val number = 0f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("0 €")
    }

    @Test
    fun `Test float is zero with two comma values if there is no comma value but its forced`() {
        val number = 0f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("0.00 €")
    }

    @Test
    fun `Test negative float with comma value is formatted correctly`() {
        val number = -1.20f
        val result = number.formatToPrice(Locale.US)
        assertThat(result).isEqualTo("-1.20 €")
    }

    @Test
    fun `test negative float without comma value and forced to two commas is formatted correctly`() {
        val number = -5f
        val result = number.formatToPrice(Locale.US, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("-5.00 €")
    }

    @Test
    fun `test negative float without comma value and forced to two commas is formatted correctly Germany`() {
        val number = -5f
        val result = number.formatToPrice(Locale.GERMAN, alwaysUseTwoCommaDigits = true)
        assertThat(result).isEqualTo("-5,00 €")
    }
}