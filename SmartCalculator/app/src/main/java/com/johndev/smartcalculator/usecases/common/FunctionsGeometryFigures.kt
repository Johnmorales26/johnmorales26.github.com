package com.johndev.smartcalculator.usecases.common

import android.content.Context
import android.view.View
import java.lang.Math.*
import java.text.DecimalFormat
import kotlin.math.pow

class FunctionsGeometryFigures(val context: Context) {
    
    val viewDecimals = ViewDecimals(context)
    
    //  Funciones Triangulo Equilatero
    fun perimeterTriangleEquilateral(sideA: Double): String {
        return viewDecimals.selectedDecimals((sideA * 3))
    }
    fun perimeterTriangleScalane(sideA: Double, sideB: Double, sideC: Double): String {
        return viewDecimals.selectedDecimals((sideA + sideB + sideC))
    }
    fun areaTriangleEquilateral(sideA: Double, sideB: Double, sideC: Double): String{
        val S = ((sideA + sideB + sideC)/ 2)
        return viewDecimals.selectedDecimals((sqrt(S * (S - sideA) * (S - sideB) * (S - sideC))))
    }
    fun angleAB(sideA: Double, sideB: Double, sideC: Double): String {
        val arCos = acos((sideA.pow(2) + sideB.pow(2) - sideC.pow(2)) / (2 * sideA * sideB))
        return viewDecimals.selectedDecimals(((arCos / PI) * 180))
    }
    fun angleBC(sideA: Double, sideB: Double, sideC: Double): String {
        val arCos = acos((sideB.pow(2) + sideC.pow(2) - sideA.pow(2)) / (2 * sideB * sideC))
        return viewDecimals.selectedDecimals(((arCos / PI) * 180))
    }
    fun angleAC(sideA: Double, sideB: Double, sideC: Double): String {
        val arCos = acos((sideA.pow(2) + sideC.pow(2) - sideB.pow(2)) / (2 * sideA * sideC))
        return viewDecimals.selectedDecimals(((arCos / PI) * 180))
    }
    fun heightA(sideA: Double, sideB: Double, sideC: Double): String{
        // Area triangle equilateral
        val S = ((sideA + sideB + sideC)/ 2)
        val areaTriangleEquilateral = (sqrt(S * (S - sideA) * (S - sideB) * (S - sideC)))
        // Height A
        return viewDecimals.selectedDecimals(((2 * areaTriangleEquilateral / sideA)))
    }
    fun heightB(sideA: Double, sideB: Double, sideC: Double): String{
        // Area triangle equilateral
        val S = ((sideA + sideB + sideC)/ 2)
        val areaTriangleEquilateral = (sqrt(S * (S - sideA) * (S - sideB) * (S - sideC)))
        // Height A
        return viewDecimals.selectedDecimals(((2 * areaTriangleEquilateral / sideB)))
    }
    fun heightC(sideA: Double, sideB: Double, sideC: Double): String{
        // Area triangle equilateral
        val S = ((sideA + sideB + sideC)/ 2)
        val areaTriangleEquilateral = (sqrt(S * (S - sideA) * (S - sideB) * (S - sideC)))
        // Height A
        return viewDecimals.selectedDecimals(((2 * areaTriangleEquilateral / sideC)))
    }

    //  Funciones Triangulo Isoseles
    fun areaTR(sideA: Double, sideB: Double): String {
        return viewDecimals.selectedDecimals((sideA * sideB) / 2)
    }
    fun perimeterTR(sideA: Double, sideB: Double): String {
        return viewDecimals.selectedDecimals(sideA + sideB + hypotenuseTR(sideA, sideB).toDouble())
    }
    fun hypotenuseTR(sideA: Double, sideB: Double): String {
        return viewDecimals.selectedDecimals(sqrt(sideA.pow(2) + sideB.pow(2)))
    }
    fun angleA_TR(sideA: Double, sideB: Double): String {
        return viewDecimals.selectedDecimals((180 * asin(sideB / hypotenuseTR(sideA, sideB).toDouble())) / PI)
    }
    fun angleB_TR(sideA: Double, sideB: Double): String {
        return viewDecimals.selectedDecimals((180 * asin(sideA / hypotenuseTR(sideA, sideB).toDouble())) / PI)
    }

    //  Funciones Cuadrado
    fun areaSquare(sideA: Double):String{
        return viewDecimals.selectedDecimals((sideA * sideA))
    }
    fun perimeterSquare(sideA: Double):String{
        return viewDecimals.selectedDecimals(sideA * 4)
    }

    //  Funciones Rectangulo
    fun areaRectangle(sideA: Double, sideB: Double):String{
        return viewDecimals.selectedDecimals(sideA * sideB)
    }
    fun perimeterRectangle(sideA: Double, sideB: Double):String{
        return viewDecimals.selectedDecimals(2 * (sideA + sideB))
    }
    fun diagonalRectangle(sideA: Double, sideB: Double):String{
        val diagonal = (sideA * sideA) + (sideB * sideB)
        return viewDecimals.selectedDecimals(sqrt(diagonal))
    }

    // Funciones Trapezoide
    fun valueS(sideA: Double, sideB: Double, sideC: Double): Double{
        return sqrt(((sideB - sideA) / 2).pow(2) + (sideC.pow(2)))
    }
    fun areaTrapezoid(sideA: Double, sideB: Double, sideC: Double):String{
        return (((sideA + sideB) / 2) * sideC).toString()
    }
    fun perimeterTrapezoid(sideA: Double, sideB: Double, sideC: Double):String{
        return viewDecimals.selectedDecimals(((2 * valueS(sideA, sideB, sideC)) + sideA + sideB))
    }

    // Funciones Rombo
    fun areaRhomb(sideA: Double, sideB: Double):String{
        return viewDecimals.selectedDecimals((sideA * sideB) / 2)
    }
    fun perimeterRhomb(sideA: Double, sideB: Double):String{
        val a:Double = sideA / 2
        val b:Double = sideB / 2
        var perimeter = (a * a) + (b * b)
        perimeter = sqrt(perimeter)
        perimeter *= 4
        return viewDecimals.selectedDecimals(perimeter)
    }

    //  Funciones Pentagono
    fun areaPentagon(sideA: Double):String{
        return viewDecimals.selectedDecimals(sideA.pow(2) * ((5 * tan((54 * PI) / (180))) / 4))
    }
    fun perimeterPentagon(sideA: Double):String{
        return viewDecimals.selectedDecimals(sideA * 5)
    }

    //  Funciones Hexagono
    fun areaHexagon(sideA: Double):String{
        return viewDecimals.selectedDecimals(sideA.pow(2) * ((3 * sqrt(3.0)) / 2))
    }
    fun perimeterHexagon(sideA: Double):String{
        return viewDecimals.selectedDecimals(sideA * 6)
    }

    //  Funciones Circulo
    fun areaCircle(radius: Double):String{
        return viewDecimals.selectedDecimals(PI * (radius * radius))
    }
    fun circunferenceCircle(radius:Double = 0.0, diameter:Double = 0.0):String{
        val perimeter = if (radius == 0.0){
            PI * diameter
        }else{
            2 * PI * radius
        }
        return viewDecimals.selectedDecimals(perimeter)
    }
    fun diameterCircle(radius: Double):String{
        return viewDecimals.selectedDecimals(radius * 2)
    }

    //  Arco Circular
    fun areaCircularArc(angle: Double, radius: Double): String {
        return viewDecimals.selectedDecimals(PI * (radius * radius) * (angle / 360))
    }
    fun perimeterCircularArc(angle: Double, radius: Double): String {
        return viewDecimals.selectedDecimals((2 * PI) * radius * (angle / 360))
    }

    //  Arco Ovalo
    fun areaOval(radiusA: Double, radiusB: Double): String {
        return viewDecimals.selectedDecimals(PI * radiusA * radiusB)
    }
    fun perimeterOval(radiusA: Double, radiusB: Double): String {
        return viewDecimals.selectedDecimals((2 * PI) * (sqrt((radiusA.pow(2) + radiusB.pow(2)) / 2)))
    }
}