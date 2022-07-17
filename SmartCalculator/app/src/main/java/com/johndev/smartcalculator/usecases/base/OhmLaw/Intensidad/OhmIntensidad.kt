package OhmLaw.Intensidad

import OhmLaw.ResourcesOhm.TypeData
import kotlin.math.sqrt

class OhmIntensidad {

    fun intensidadVR(volts: Double, resistencia: Double, rVolts: TypeData, rResistencia: TypeData): Double {
        return when(rVolts){
            TypeData.VOLTIO -> {
                when(rResistencia){
                    TypeData.OHM -> {
                        //  Voltio / Ohm
                        val intensidad = volts / resistencia
                        intensidad
                    }
                    TypeData.MILLIOHM -> {
                        //  Voltio / Milliohm
                        val intensidad = volts / (resistencia / 1000)
                        intensidad
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rResistencia){
                    TypeData.OHM -> {
                        //  Milivoltio / Ohm
                        val intensidad = (volts / 1000) / resistencia
                        intensidad
                    }
                    TypeData.MILLIOHM -> {
                        //  Milivoltio / Milliohm
                        val intensidad = (volts / 1000) / (resistencia / 1000)
                        intensidad
                    }
                    else -> 0.0
                }
            }
             else -> 0.0
         }
    }

    fun intensidadPV(volts: Double, potencia: Double, rVolts: TypeData, rPotencia: TypeData): Double {
        return when(rVolts){
            TypeData.VOLTIO -> {
                when(rPotencia){
                    //  Voltio & Watio
                    TypeData.WATIO -> {
                        val result = potencia / volts
                        result
                    }
                    //  Voltio & Milivatios
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / volts
                        result
                    }
                    //  Voltio & Kilovatio
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / volts
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILIVOLTIO -> {
                when(rPotencia){
                    //  Milivoltio & Watio
                    TypeData.WATIO -> {
                        val result = potencia / (volts / 1000)
                        result
                    }
                    //  Milivoltio & Milivatios
                    TypeData.MILIVATIOS -> {
                        val result = (potencia / 1000) / (volts / 1000)
                        result
                    }
                    //  Milivoltio & Kilovatio
                    TypeData.KILOVATIO -> {
                        val result = (potencia * 1000) / (volts / 1000)
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

    fun intensidadPR(potencia: Double, resistencia: Double, rPotencia: TypeData, rResistencia: TypeData): Double {
        return when(rResistencia){
            TypeData.OHM -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = sqrt(potencia / resistencia)
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = sqrt((potencia / 1000) / resistencia)
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = sqrt((potencia * 1000) / resistencia)
                        result
                    }
                    else -> 0.0
                }
            }
            TypeData.MILLIOHM -> {
                when(rPotencia){
                    TypeData.WATIO -> {
                        val result = sqrt(potencia / (resistencia / 1000))
                        result
                    }
                    TypeData.MILIVATIOS -> {
                        val result = sqrt((potencia / 1000) / (resistencia / 1000))
                        result
                    }
                    TypeData.KILOVATIO -> {
                        val result = sqrt((potencia * 1000) / (resistencia / 1000))
                        result
                    }
                    else -> 0.0
                }
            }
            else -> 0.0
        }
    }

}