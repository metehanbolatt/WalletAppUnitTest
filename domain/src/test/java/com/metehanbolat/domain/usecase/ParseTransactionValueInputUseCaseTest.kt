package com.metehanbolat.domain.usecase

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ParseTransactionValueInputUseCaseTest {

    private val transactionValueInputCase = ParseTransactionValueInputUseCase()

    @Test
    fun `Test zero without comma returns false`() {
        val result = transactionValueInputCase("0")
        assertThat(result).isFalse()
    }

    @Test
    fun `Test zero with comma returns false`() {
        val result = transactionValueInputCase("0,00")
        assertThat(result).isFalse()
    }

    @Test
    fun `Test multiple zero with comma returns false`() {
        val result = transactionValueInputCase("000,00")
        assertThat(result).isFalse()
    }

    @Test
    fun `Test zero before comma and value after comma returns true`() {
        val result = transactionValueInputCase("0,20")
        assertThat(result).isTrue()
    }

    @Test
    fun `Test zero before comma and a second value after comma returns true`() {
        val result = transactionValueInputCase("0,02")
        assertThat(result).isTrue()
    }

    @Test
    fun `Test normal single value without comma returns true`() {
        val result = transactionValueInputCase("2")
        assertThat(result).isTrue()
    }

    @Test
    fun `Test normal value with one comma value after returns true`() {
        val result = transactionValueInputCase("2,1")
        assertThat(result).isTrue()
    }

    @Test
    fun `Test normal value with two comma values after return true`() {
        val result = transactionValueInputCase("2,13")
        assertThat(result).isTrue()
    }

    @Test
    fun `Test too long value returns false`() {
        val result = transactionValueInputCase("2,131")
        assertThat(result).isFalse()
    }

    @Test
    fun `Test no value returns false`() {
        val result = transactionValueInputCase("1412a")
        assertThat(result).isFalse()
    }

    @Test
    fun `Test leading zero value returns true`() {
        val result = transactionValueInputCase("02,21")
        assertThat(result).isTrue()
    }

}