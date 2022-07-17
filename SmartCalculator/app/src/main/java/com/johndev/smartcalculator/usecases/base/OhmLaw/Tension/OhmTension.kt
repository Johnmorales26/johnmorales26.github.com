package OhmLaw.Tension

import OhmLaw.Resistencia.OhmResistencia
import OhmLaw.ResourcesOhm.TypeData
import kotlin.math.sqrt

class OhmTension {

    fun tensionRI(resistencia: Double, corriente: Double, rResistencia: TypeData, rCorriente: TypeData): Double {
        return when(rResistencia){
            TypeData.OHM -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = resistencia * corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = resistencia * (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILLIOHM -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = (resistencia / 1000) * corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = (resistencia / 1000) * (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun tensionPI(potencia: Double, corriente: Double, rPotencia: TypeData, rCorriente: TypeData): Double {
        return when(rCorriente){
            TypeData.AMPERIO -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = potencia / corriente
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / corriente
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / corriente
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIAMPERIOS -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = potencia / (corriente / 1000)
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / (corriente / 1000)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> { 0.0 }
        }
    }

    fun tensionPR(potencia: Double, resistencia: Double, rPotencia: TypeData, rResistencia: TypeData): Double {
        return when(rResistencia){
            TypeData.OHM -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = sqrt(potencia * resistencia)
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = sqrt((potencia / 1000) * resistencia)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = sqrt((potencia * 1000) * resistencia)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILLIOHM -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = sqrt(potencia * (resistencia / 1000))
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = sqrt((potencia / 1000) * (resistencia / 1000))
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = sqrt((potencia * 1000) * (resistencia / 1000))
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

}