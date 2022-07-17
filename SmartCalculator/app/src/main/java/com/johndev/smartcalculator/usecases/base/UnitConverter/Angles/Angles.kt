package DataClases.Angles

import DataClases.Angles.AnglesTypes.radian
import DataClases.Angles.AnglesTypes.circulo
import DataClases.Angles.AnglesTypes.cuadrante
import DataClases.Angles.AnglesTypes.grado
import DataClases.Angles.AnglesTypes.minuto
import DataClases.Angles.AnglesTypes.segundo
import DataClases.Angles.AnglesTypes.sextante

class Angles {

    fun radianTo(radian: Double): MutableMap<String, Double>{
        val radianTo: MutableMap<String, Double> = mutableMapOf()
        radianTo[AnglesTypes.radian] = radian * 1
        radianTo[grado] = radian * 63.661977236667
        radianTo[minuto] = radian * 3437.75
        radianTo[segundo] = radian * 206264.8
        radianTo[sextante] = radian * 0.9549
        radianTo[cuadrante] = radian * 0.6366
        radianTo[circulo] = radian * 0.1592
        return radianTo
    }

    fun gradoTo(grado: Double): MutableMap<String, Double>{
        val gradoTo: MutableMap<String, Double> = mutableMapOf()
        gradoTo[radian] = grado * 0.0175
        gradoTo[AnglesTypes.grado] = grado * 1
        gradoTo[minuto] = grado * 60
        gradoTo[segundo] = grado * 3600
        gradoTo[sextante] = grado * 0.01667
        gradoTo[cuadrante] = grado * 0.0111
        gradoTo[circulo] = grado * 0.002778
        return gradoTo
    }

    fun minutoTo(minuto: Double): MutableMap<String, Double>{
        val minutoTo: MutableMap<String, Double> = mutableMapOf()
        minutoTo[radian] = minuto * 0.0002909
        minutoTo[grado] = minuto * 0.01667
        minutoTo[AnglesTypes.minuto] = minuto * 1
        minutoTo[segundo] = minuto * 60
        minutoTo[sextante] = minuto * 0.000278
        minutoTo[cuadrante] = minuto * 0.000185
        minutoTo[circulo] = minuto * 0.0000463
        return minutoTo
    }

    fun segundoTo(segundo: Double): MutableMap<String, Double>{
        val segundoTo: MutableMap<String, Double> = mutableMapOf()
        segundoTo[radian] = segundo * 0.00000485
        segundoTo[grado] = segundo * 0.0002778
        segundoTo[minuto] = segundo * 0.01667
        segundoTo[AnglesTypes.segundo] = segundo * 1
        segundoTo[sextante] = segundo * 0.00000462962962962964
        segundoTo[cuadrante] = segundo * 0.000003086419753086
        segundoTo[circulo] = segundo * 0.000000772
        return segundoTo
    }

    fun sextanteTo(sextante: Double): MutableMap<String, Double>{
        val sextanteTo: MutableMap<String, Double> = mutableMapOf()
        sextanteTo[radian] = sextante * 1.047197551197
        sextanteTo[grado] = sextante * 60
        sextanteTo[minuto] = sextante * 3600
        sextanteTo[segundo] = sextante * 216000
        sextanteTo[AnglesTypes.sextante] = sextante * 1
        sextanteTo[cuadrante] = sextante * 0.6666666666667
        sextanteTo[circulo] = sextante * 0.166666666666667
        return sextanteTo
    }

    fun cuadranteTo(cuadrante: Double): MutableMap<String, Double>{
        val cuadranteTo: MutableMap<String, Double> = mutableMapOf()
        cuadranteTo[radian] = cuadrante * 1.570796326795
        cuadranteTo[grado] = cuadrante * 90
        cuadranteTo[minuto] = cuadrante * 5400
        cuadranteTo[segundo] = cuadrante * 324000
        cuadranteTo[sextante] = cuadrante * 1.5
        cuadranteTo[AnglesTypes.cuadrante] = cuadrante * 1
        cuadranteTo[circulo] = cuadrante * 0.25
        return cuadranteTo
    }

    fun circuloTo(circulo: Double): MutableMap<String, Double>{
        val circuloTo: MutableMap<String, Double> = mutableMapOf()
        circuloTo[radian] = circulo * 6.28318530718
        circuloTo[grado] = circulo * 360
        circuloTo[minuto] = circulo * 21600
        circuloTo[segundo] = circulo * 1296000
        circuloTo[sextante] = circulo * 6
        circuloTo[cuadrante] = circulo * 4
        circuloTo[AnglesTypes.circulo] = circulo * 1
        return circuloTo
    }

}