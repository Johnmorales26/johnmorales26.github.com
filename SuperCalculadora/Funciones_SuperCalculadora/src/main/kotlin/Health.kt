import java.text.DecimalFormat
import kotlin.math.pow

class Health {
    //  IMC Calculation
    fun calculationIMC(height: Double, weight: Double): String{
        return two_Decimals(weight / (height.pow(2)))
    }fun calculationImperialIMC(height: Double, weight: Double): String{
        return two_Decimals((weight * 703) / (height.pow(2)))
    }
    fun evaluatingIMC(IMC: String): String{
        val IMCd = IMC.toDouble()
        if (IMCd <= 18.5){
            return "Bajo Peso: Su IMC: $IMC es menor que 18.5"
        } else if (IMCd <= 24.9){
            return "Peso Normal: Su IMC: $IMC es menor que 24.9"
        } else if (IMCd <= 29.9){
            return "Sobrepeso: Su IMC: $IMC es menor que 29.9"
        } else if (IMCd <= 34.9){
            return "Obesidad I: Su IMC: $IMC es menor que 34.9"
        } else if (IMCd <= 39.9){
            return "Obesidad II: Su IMC: $IMC es menor que 39.9"
        }else if (IMCd >= 40){
            return "Obesidad III: Su IMC: $IMC es mayor que 40"
        }
        return "No se a podido determinar..."
    }
    // BMR
    fun bmrMen(weight: Double, height:Double, age: Int): Double{
        return ((13.75 + weight) + (5 * height) - (6.76 * age) + 66)
    }
    fun bmrWomen(weight: Double, height:Double, age: Int): Double{
        return ((9.56 + weight) + (1.85 * height) - (4.68 * age) + 655)
    }
    fun bmrTotal(BMR: Double, lifeStyle: String): String{
        var lifeStyle1 = lifeStyle.toUpperCase()
        when(lifeStyle1){
            "NO EXERCISE" -> return two_Decimals(BMR * 1.2)
            "1-3 DAYS / WEEK" -> return two_Decimals(BMR * 1.375)
            "3-5 DAYS / WEEK" -> return two_Decimals(BMR * 1.55)
            "MOST DAYS" -> return two_Decimals(BMR * 1.725)
            "EVERY DAY" -> return two_Decimals(BMR * 1.9)
        }
        return "No es posible calcular"
    }
    private fun two_Decimals(value: Double): String{
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        val formating = dec.format(number)
        return formating
    }
}