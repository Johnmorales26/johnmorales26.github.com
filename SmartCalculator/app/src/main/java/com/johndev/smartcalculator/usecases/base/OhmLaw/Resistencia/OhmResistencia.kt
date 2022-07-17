package OhmLaw.Resistencia

import OhmLaw.ResourcesOhm.TypeData
import kotlin.math.pow

class OhmResistencia {

    fun resistenciaVI(volts: Double, corriente: Double, rVolts: TypeData, rCorriente: TypeData): Double {
        return when(rVolts){
            TypeData.VOLTIO -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = volts / corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = volts / (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = (volts / 1000) / corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = (volts / 1000) / (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun resistenciaVP(volts: Double, potencia: Double, rVolts: TypeData, rPotencia: TypeData): Double {
        return when(rVolts) {
            TypeData.VOLTIO -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = volts.pow(2.0) / potencia
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = volts.pow(2.0) / (potencia / 1000)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = volts.pow(2.0) / (potencia * 1000)
                        result
                    }
                    else -> { 0.0 }
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = (volts / 1000).pow(2.0) / potencia
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = (volts / 1000).pow(2.0) / (potencia / 1000)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = (volts / 1000).pow(2.0) / (potencia * 1000)
                        result
                    }
                    else -> { 0.0 }
                }
            }
            else -> { 0.0 }
        }
    }

    fun resistenciaPI(corriente: Double, potencia: Double, rCorriente: TypeData, rPotencia: TypeData): Double {
        return when(rCorriente) {
            TypeData.AMPERIO -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = potencia / corriente.pow(2)
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / corriente.pow(2)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / corriente.pow(2)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIAMPERIOS -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = potencia / (corriente / 1000).pow(2)
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / (corriente / 1000).pow(2)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / (corriente / 1000).pow(2)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

}