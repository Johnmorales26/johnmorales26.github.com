package com.johndev.aitrainer.format

import java.text.DecimalFormat

class NumberFormat {

    fun getTwoDecimals(value: Float): String? {
        val df = DecimalFormat("0.000000")
        return df.format(value)
    }

}