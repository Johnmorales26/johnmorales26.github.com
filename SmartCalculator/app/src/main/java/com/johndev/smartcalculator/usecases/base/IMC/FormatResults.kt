package IMC

import java.text.DecimalFormat

class FormatResults {
    fun twoDecimals(value: Double): String {
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        return dec.format(number)
    }
}