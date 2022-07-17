package OhmLaw.Potencia

import OhmLaw.ResourcesOhm.TypeData
import java.lang.reflect.Type
import kotlin.math.pow

class OhmPotencia {

    fun potenciaVI(voltios: Double, corriente: Double, rVoltios: TypeData, rCorriente: TypeData): Double {
        return when(rVoltios){
            TypeData.VOLTIO -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = voltios * corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = voltios * (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = (voltios / 1000) * corriente
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = (voltios / 1000) * (corriente / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun potenciaRI(resistencia: Double, corriente: Double, rResistencia: TypeData, rCorriente: TypeData): Double{
        return when(rResistencia){
            TypeData.OHM -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = resistencia * corriente.pow(2)
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = resistencia * (corriente / 1000).pow(2)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILLIOHM -> {
                when(rCorriente){
                    TypeData.AMPERIO -> {
                        val result = (resistencia / 1000) * corriente.pow(2)
                        result
                    }
                    TypeData.MILIAMPERIOS -> {
                        val result = (resistencia / 1000) * (corriente / 1000).pow(2)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun potenciaVR(voltios: Double, resistencia: Double, rVoltios: TypeData, rResistencia: TypeData): Double{
        return when(rVoltios){
            TypeData.VOLTIO -> {
                when(rResistencia){
                    TypeData.OHM -> {
                        val result = voltios.pow(2) / resistencia
                        result
                    }
                    TypeData.MILLIOHM -> {
                        val result = voltios.pow(2) / (resistencia / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rResistencia){
                    TypeData.OHM -> {
                        val result = (voltios / 1000).pow(2) / resistencia
                        result
                    }
                    TypeData.MILLIOHM -> {
                        val result = (voltios / 1000).pow(2) / (resistencia / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

}