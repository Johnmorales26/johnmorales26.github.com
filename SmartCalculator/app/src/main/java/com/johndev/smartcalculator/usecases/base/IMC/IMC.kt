package IMC

import java.text.DecimalFormat
import kotlin.math.pow


class IMC {

    fun imcMetrico(altuta: Double, peso: Double): Double{
        val cm = altuta / 100
        return peso / cm.pow(2.0)
    }

    fun imcImperial(pieFT: Double, pulgadaIN: Double, peso: Double): Double{
        //  1 Pie es igual a 12 Pulgadas
        //  1 Pulgada es igual a 2.54cm
        val pulgadas = pieFT * 12
        val totalcm = (pulgadaIN + pulgadas) * 2.54
        val kilogramos = peso / 2.205
        return imcMetrico(totalcm, kilogramos)
    }

}