import java.text.DecimalFormat
import kotlin.math.*

class Geometry2D {

    //  Funciones Triangulo Equilatero
    fun perimeterTriangleEquilateral(sideA: Double): String {
        return two_Decimals((sideA * 3))
    }
    fun perimeterTriangleScalane(sideA: Double, sideB: Double, sideC: Double): String {
        return two_Decimals((sideA + sideB + sideC))
    }
    fun areaTriangleEquilateral(sideA: Double, sideB: Double, sideC: Double): String{
        var S = ((sideA + sideB + sideC)/ 2)
        return two_Decimals((sqrt(S * (S - sideA) * (S - sideB) * (S - sideC))))
    }
    fun angleAB(sideA: Double, sideB: Double, sideC: Double): String {
        var arCos = acos((sideA.pow(2) + sideB.pow(2) - sideC.pow(2)) / (2 * sideA * sideB))
        return two_Decimals(((arCos / PI) * 180))
    }
    fun angleBC(sideA: Double, sideB: Double, sideC: Double): String {
        var arCos = acos((sideB.pow(2) + sideC.pow(2) - sideA.pow(2)) / (2 * sideB * sideC))
        return two_Decimals(((arCos / PI) * 180))
    }
    fun angleAC(sideA: Double, sideB: Double, sideC: Double): String {
        var arCos = acos((sideA.pow(2) + sideC.pow(2) - sideB.pow(2)) / (2 * sideA * sideC))
        return two_Decimals(((arCos / PI) * 180))
    }
    fun heightA(sideA: Double, sideB: Double, sideC: Double): String{
        return two_Decimals(((2 * areaTriangleEquilateral(sideA, sideB, sideC).toDouble()) / sideA))
    }
    fun heightB(sideA: Double, sideB: Double, sideC: Double): String{
        return two_Decimals(((2 * areaTriangleEquilateral(sideA, sideB, sideC).toDouble()) / sideB))
    }
    fun heightC(sideA: Double, sideB: Double, sideC: Double): String{
        return two_Decimals(((2 * areaTriangleEquilateral(sideA, sideB, sideC).toDouble()) / sideC))
    }

    //  Funciones Triangulo Isoseles
    fun areaTR(sideA: Double, sideB: Double): String {
        return two_Decimals((sideA * sideB) / 2)
    }
    fun perimeterTR(sideA: Double, sideB: Double): String {
        return two_Decimals(sideA * sideB * hypotenuseTR(sideA, sideB).toDouble())
    }
    fun hypotenuseTR(sideA: Double, sideB: Double): String {
        return two_Decimals(sqrt(sideA.pow(2) + sideB.pow(2)))
    }
    fun angleA_TR(sideA: Double, sideB: Double): String {
        return two_Decimals((180 * asin(sideB / hypotenuseTR(sideA, sideB).toDouble())) / PI)
    }
    fun angleB_TR(sideA: Double, sideB: Double): String {
        return two_Decimals((180 * asin(sideA / hypotenuseTR(sideA, sideB).toDouble())) / PI)
    }

    //  Funciones Cuadrado
    fun areaSquare(sideA: Double):String{
        return (sideA * sideA).toString()
    }
    fun perimeterSquare(sideA: Double):String{
        return (sideA * 4).toString()
    }

    //  Funciones Rectangulo
    fun areaRectangle(sideA: Double, sideB: Double):String{
        return (sideA * sideB).toString()
    }
    fun perimeterRectangle(sideA: Double, sideB: Double):String{
        return (2 * (sideA + sideB)).toString()
    }
    fun diagonalRectangle(sideA: Double, sideB: Double):String{
        val diagonal = (sideA * sideA) + (sideB * sideB)
        return sqrt(diagonal).toString()
    }

    // Funciones Trapezoide
    fun valueS(sideA: Double, sideB: Double, sideC: Double): Double{
        return sqrt(((sideB - sideA) / 2).pow(2) + (sideC.pow(2)))
    }
    fun areaTrapezoid(sideA: Double, sideB: Double, sideC: Double):String{
        return (((sideA + sideB) / 2) * sideC).toString()
    }
    fun perimeterTrapezoid(sideA: Double, sideB: Double, sideC: Double):String{
        return two_Decimals(((2 * valueS(sideA, sideB, sideC)) + sideA + sideB))
    }

    // Funciones Rombo
    fun areaRhomb(sideA: Double, sideB: Double):String{
        return ((sideA * sideB) / 2).toString()
    }
    fun perimeterRhomb(sideA: Double, sideB: Double):String{
        val a:Double = sideA / 2
        val b:Double = sideB / 2
        var perimeter = (a * a) + (b * b)
        perimeter = sqrt(perimeter)
        perimeter *= 4
        return perimeter.toString()
    }

    //  Funciones Pentagono
    fun areaPentagon(sideA: Double, sideB: Double):String{
        val p = perimeterPentagon(sideA).toDouble()
        var area = (p * sideB)
        area /= 2
        return area.toString()
    }
    fun perimeterPentagon(sideA: Double):String{
        return (sideA * 5).toString()
    }

    //  Funciones Hexagono
    fun areaHexagon(sideA: Double, sideB: Double):String{
        return (3 * sideB * sideA).toString()
    }
    fun perimeterHexagon(sideA: Double):String{
        return (sideA * 6).toString()
    }

    //  Funciones Circulo
    fun areaCircle(radius: Double):String{
        return (PI * (radius * radius)).toString()
    }
    fun circunferenceCircle(radius:Double = 0.0, diameter:Double = 0.0):String{
        val perimeter = if (radius == 0.0){
            PI * diameter
        }else{
            2 * PI * radius
        }
        return perimeter.toString()
    }
    fun diameterCircle(radius: Double):String{
        return (radius * 2).toString()
    }

    //  Arco Circular
    fun areaCircularArc(angle: Double, radius: Double): String {
        return (PI * (radius * radius) * (angle / 360)).toString()
    }
    fun perimeterCircularArc(angle: Double, radius: Double): String {
        return ((2 * PI) * radius * (angle / 360)).toString()
    }

    //  Arco Ovalo
    fun areaOval(radiusA: Double, radiusB: Double): String {
        return (PI * radiusA * radiusB).toString()
    }
    fun perimeterOval(radiusA: Double, radiusB: Double): String {
        return ((2 * PI) * sqrt((radiusA.pow(2) * radiusB.pow(2)) / 2)).toString()
    }
    private fun two_Decimals(value: Double):String{
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        val formating = dec.format(number)
        return formating
    }
}