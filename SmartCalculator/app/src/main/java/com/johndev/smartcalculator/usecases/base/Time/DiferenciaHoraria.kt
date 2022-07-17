package Time

import java.text.ParseException
import java.text.SimpleDateFormat


class DiferenciaHoraria {

    private val SECONDS_IN_ONE_DAY = 86400
    private val SECONDS_IN_ONE_HOUR = 3600
    private val SECONDS_IN_ONE_MINUTE = 60

    fun calculate(hora1: String, hora2: String): Horas {
        try {
            val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
            val startDate = simpleDateFormat.parse(hora1)
            val endDate = simpleDateFormat.parse(hora2)
            val start = startDate.time / 1000
            var end = endDate.time / 1000
            if (end < start) end += SECONDS_IN_ONE_DAY
            var difference = (end - start).toInt()
            val days: Int = difference / SECONDS_IN_ONE_DAY
            difference %= SECONDS_IN_ONE_DAY
            val hours: Int = difference / SECONDS_IN_ONE_HOUR
            difference %= SECONDS_IN_ONE_HOUR
            val minutes: Int = difference / SECONDS_IN_ONE_MINUTE
            difference %= SECONDS_IN_ONE_MINUTE
            println("Days: $days, Hours: $hours, Mins: $minutes, Seconds: $difference")
            return Horas(days, hours, minutes, difference)
        } catch (e: ParseException) {
            e.printStackTrace()
            return Horas(0,0,0,0)
        }
    }
}
