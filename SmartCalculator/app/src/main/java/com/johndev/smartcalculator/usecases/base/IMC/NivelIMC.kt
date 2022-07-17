package IMC

class NivelIMC {

    fun imcLevel(imc: Double): String{
        return when{
            imc < 18.5 -> "Bajo Peso"
            imc > 18.5 && imc < 24.9 -> "Normal"
            imc > 25.0 && imc < 29.9 -> "Sobrepeso"
            imc > 30.0 -> "Obesidad"
            else -> "Error De Datos"
        }
    }

}