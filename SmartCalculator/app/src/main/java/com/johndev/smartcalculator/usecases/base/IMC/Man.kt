package IMC

fun main() {
    val imcMetrico = IMC()
    val format = FormatResults()
    val imvLevel = NivelIMC()
    val peso1 = format.twoDecimals(imcMetrico.imcMetrico(180.0, 90.0)).toDouble()
    val peso2 = format.twoDecimals(imcMetrico.imcImperial(5.0, 11.0, 198.416)).toDouble()
    println(format.twoDecimals(peso1))
    println(imvLevel.imcLevel(peso1))
    println(format.twoDecimals(peso2))
    println(imvLevel.imcLevel(peso2))
}