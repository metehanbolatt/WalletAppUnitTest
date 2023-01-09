package com.metehanbolat.domain.usecase

import java.text.DecimalFormatSymbols

class ParseTransactionValueInputUseCase {

    operator fun invoke(value: String): Boolean {
        val decimalPointFormat = DecimalFormatSymbols.getInstance().decimalSeparator

        val regexForNull = "0+$decimalPointFormat?[0]{0,2}".toRegex()
        if (value.matches(regex = regexForNull)) {
            return false
        }

        val regexGeneral = "[0-9]*$decimalPointFormat?[0-9]{1,2}".toRegex()
        return value.matches(regex = regexGeneral)
    }
}