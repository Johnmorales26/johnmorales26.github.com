package OhmLaw.ResourcesOhm

class DataTransform {

    fun voltsTo(volts: Double, returnData: TypeData): String{
        return when(returnData){
            TypeData.VOLTIO -> "$volts V"
            TypeData.MILIVOLTIO -> {
                val result = volts * 1000
                "$result mV"
            }
            else -> returnError()
        }
    }

    fun corrienteTo(corriente: Double, returnData: TypeData): String{
        return when(returnData){
            TypeData.AMPERIO -> "$corriente A"
            TypeData.MILIAMPERIOS -> {
                val result = corriente * 1000
                "$result mA"
            }
            else -> returnError()
        }
    }

    fun resistenciaTo(resistencia: Double, returnData: TypeData): String{
        return when(returnData){
            TypeData.OHM -> "$resistencia Ω"
            TypeData.MILLIOHM -> {
                val result = resistencia * 1000
                "$result mΩ"
            }
            else -> returnError()
        }
    }

    fun potenciaTo(potencia: Double, returnData: TypeData): String{
        return when(returnData){
            TypeData.WATIO -> { "$potencia W" }
            TypeData.MILIVATIOS -> {
                val result = potencia * 1000
                "$result mW"
            }
            TypeData.KILOVATIO -> {
                val result = potencia / 1000
                "$result kW"
            }
            else -> returnError()
        }
    }

    private fun returnError() = "Error De Datos"

}