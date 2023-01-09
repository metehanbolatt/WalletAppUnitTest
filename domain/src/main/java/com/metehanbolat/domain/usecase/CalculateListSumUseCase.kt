package com.metehanbolat.domain.usecase

class CalculateListSumUseCase {

    operator fun invoke(list: List<Float>): Float {
        var result = 0f
        for (element in list) {
            result += element
        }
        return result
    }
}