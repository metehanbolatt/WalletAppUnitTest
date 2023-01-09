package com.metehanbolat.domain.usecase

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculateListSumUseCaseTest {

    private lateinit var calculateListSumUseCase: CalculateListSumUseCase

    @Before
    fun `Create CalculateListSumUseCase`() {
        calculateListSumUseCase = CalculateListSumUseCase()
    }

    @Test
    fun `Test result with empty list is null`() {
        val result = calculateListSumUseCase(emptyList())
        assertThat(result).isEqualTo(0f)
    }

    @Test
    fun `Test result with one list element`() {
        val result = calculateListSumUseCase(listOf(2.3f))
        assertThat(result).isEqualTo(2.3f)
    }

    @Test
    fun `Test result with multiple list elements`() {
        val result = calculateListSumUseCase(listOf(2.3f, 3.12f, 5f))
        assertThat(result).isEqualTo(10.42f)
    }

    @Test
    fun `Test result with multiple list elements which result in a negative number`() {
        val result = calculateListSumUseCase(listOf(2.3f, 3.12f, -15f))
        assertThat(result).isEqualTo(-9.58f)
    }

}