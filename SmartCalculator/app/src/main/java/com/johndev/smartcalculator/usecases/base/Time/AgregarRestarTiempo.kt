package Time

import android.os.Build
import androidx.annotation.RequiresApi

class AgregarRestarTiempo {
    @RequiresApi(Build.VERSION_CODES.N)
    fun subtractHour(hora1: Horas, hora2: Horas): Horas{
        var zonaHoraria: HourDay = HourDay.AM
        // Pasar horas a min
        val hrsToMin1 = horasToMin(hora1.hora)
        val hrsToMin2 = horasToMin(hora2.hora)
        // Sumar todos los minutos
        var allMinutes = (hrsToMin1 + hora1.minuto) - (hrsToMin2 + hora2.minuto)
        if (allMinutes <= -1){
            //  Evaluar cuando sean dos dias en adelante
            while (allMinutes <= -1441){
                allMinutes += 1440
            }
            //  Evaluar cuando sea mayor a un dia
            var finallyHour = allMinutes / 60
            when(finallyHour){
                -24 -> finallyHour = 1
                -23 -> finallyHour = 2
                -22 -> finallyHour = 3
                -21 -> finallyHour = 4
                -20 -> finallyHour = 5
                -19 -> finallyHour = 6
                -18 -> finallyHour = 7
                -17 -> finallyHour = 8
                -16 -> finallyHour = 9
                -15 -> finallyHour = 10
                -14 -> finallyHour = 11
                -13 -> finallyHour = 12
                -12 -> finallyHour = 13
                -11 -> finallyHour = 14
                -10 -> finallyHour = 15
                -9 -> finallyHour = 16
                -8 -> finallyHour = 17
                -7 -> finallyHour = 18
                -6 -> finallyHour = 19
                -5 -> finallyHour = 20
                -4 -> finallyHour = 21
                -3 -> finallyHour = 22
                -2 -> finallyHour = 23
                -1 -> finallyHour = 24
                -0 -> finallyHour = 25
            }
            finallyHour -= 2
            when(finallyHour){
                1,12 -> zonaHoraria = HourDay.AM
                13,24 -> zonaHoraria = HourDay.PM
            }
            val finallyMinutes = Math.floorMod(allMinutes, 60)
            return Horas(hora = finallyHour, minuto = finallyMinutes, dia = zonaHoraria)
        }
        //  Evaluar la hora final
        val finallyHour = allMinutes / 60
        val finallyMinutes = Math.floorMod(allMinutes, 60)
        when(finallyHour){
            1,12 -> zonaHoraria = HourDay.AM
            13,24 -> zonaHoraria = HourDay.PM
        }
        return Horas(hora = finallyHour, minuto = finallyMinutes, dia = zonaHoraria)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun addHours(hora1: Horas, hora2: Horas): Horas{
        var zonaHoraria: HourDay = HourDay.AM
        // Pasar horas a min
        val hrsToMin1 = horasToMin(hora1.hora)
        val hrsToMin2 = horasToMin(hora2.hora)
        // Sumar todos los minutos
        var allMinutes = (hrsToMin1 + hora1.minuto) + (hrsToMin2 + hora2.minuto)
        //  Evaluar la hora final
        var finallyHour = allMinutes / 60
        val finallyMinutes = Math.floorMod(allMinutes, 60)
        while (finallyHour > 48){
            finallyHour -= 24
        }
        when(finallyHour){
            25 -> finallyHour = 1
            26 -> finallyHour = 2
            27 -> finallyHour = 3
            28 -> finallyHour = 4
            29 -> finallyHour = 5
            30 -> finallyHour = 6
            31 -> finallyHour = 7
            32 -> finallyHour = 8
            33 -> finallyHour = 9
            34 -> finallyHour = 10
            35 -> finallyHour = 11
            36 -> finallyHour = 12
            37 -> finallyHour = 13
            38 -> finallyHour = 14
            39 -> finallyHour = 15
            40 -> finallyHour = 16
            41 -> finallyHour = 17
            42 -> finallyHour = 18
            43 -> finallyHour = 19
            44 -> finallyHour = 20
            45 -> finallyHour = 21
            46 -> finallyHour = 22
            47 -> finallyHour = 23
            48 -> finallyHour = 24
        }
        when(finallyHour){
            1,12 -> zonaHoraria = HourDay.AM
            13,24 -> zonaHoraria = HourDay.PM
        }
        return Horas(hora = finallyHour, minuto = finallyMinutes, dia = zonaHoraria)
    }

    private fun horasToMin(horas: Int): Int{
        return horas * 60
    }
}