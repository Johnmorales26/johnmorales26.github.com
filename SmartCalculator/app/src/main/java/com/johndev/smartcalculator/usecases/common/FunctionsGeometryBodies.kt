package com.johndev.smartcalculator.usecases.common

import java.lang.Math.*
import java.text.DecimalFormat
import kotlin.math.pow

class FunctionsGeometryBodies {
    //  Cube Funtions
    fun totalAreaCube(longA:Double):String{
        return two_Decimals(6 * longA.pow(2))
    }
    fun lateralAreaCube(longA:Double):String{
        return two_Decimals(4 * longA.pow(2))
    }
    fun volumeCube(longA: Double):String{
        return two_Decimals(longA.pow(3))
    }

    //  Prism Functions
    fun totalAreaPrism(sideA:Double, sideB:Double, sideC:Double):String{
        return two_Decimals((2 * (sideA * sideB)) + (2 * (sideB * sideC)) + (2 * (sideA * sideC)))
    }
    fun lateralAreaPrism(sideA:Double, sideB:Double, sideC:Double):String{
        return two_Decimals((2 * (sideA * sideB)) + (2 * (sideA * sideC)))
    }
    fun volumePrism(sideA:Double, sideB:Double, sideC:Double):String{
        return two_Decimals(sideA * sideB * sideC)
    }

    //  Pyramid Functions
    fun totalAreaPyramid(sideA:Double, height:Double):String{
        val squareRoot = sqrt(height.pow(2) + (sideA / 2).pow(2))
        val totalArea = ((2 * sideA) * squareRoot)
        return two_Decimals(totalArea + sideA.pow(2))
    }
    fun lateralAreaPyramid(sideA:Double, height:Double):String{
        val squareRoot = sqrt(height.pow(2) + (sideA / 2).pow(2))
        return two_Decimals(((2 * sideA) * squareRoot))
    }
    fun volumePyramid(sideA:Double, height:Double):String{
        return two_Decimals(sideA.pow(2) * (height / 3))
    }

    //  Short Pyramid Functions
    fun totalAreaShortPyramid(sideA:Double, sideB: Double, height:Double):String{
        val totalArea = (2 * (sideA + sideB) * sqrt(height.pow(2) + ((sideB - sideA) / 2).pow(2)))
        return two_Decimals(totalArea + sideA.pow(2) + sideB.pow(2))
    }
    fun lateralAreaShortPyramid(sideA:Double, sideB: Double, height:Double):String{
        return two_Decimals(2 * (sideA + sideB) * sqrt(height.pow(2) + ((sideB - sideA) / 2).pow(2)))
    }
    fun volumeShortPyramid(sideA:Double, sideB: Double, height:Double):String{
        return two_Decimals(((sideA.pow(2) + sideA * sideB + sideB.pow(2)) * height) / 3)
    }

    //  Pyramid Cone
    fun totalAreaCone(radius:Double, height:Double):String{
        val square = sqrt(radius.pow(2) + height.pow(2))
        val totalArea = (PI * radius * square)
        return two_Decimals((totalArea + (PI * radius.pow(2))))
    }
    fun lateralAreaCone(radius:Double, height:Double):String{
        val square = sqrt(radius.pow(2) + height.pow(2))
        return two_Decimals((PI * radius * square))
    }
    fun volumeCone(radius:Double, height:Double):String{
        return two_Decimals(((PI * radius.pow(2) * height) / 3))
    }

    //  Pyramid Cone Cut
    fun totalAreaConeCut(radiusA:Double, radiusB:Double, height:Double):String{
        val lateralArea = (PI * (radiusA + radiusB) * calcS(radiusA, radiusB, height))
        return two_Decimals(lateralArea + (PI * radiusA.pow(2)) + (PI * radiusB.pow(2)))
    }
    fun lateralAreaConeCut(radiusA:Double, radiusB:Double, height:Double):String{
        return two_Decimals((PI * (radiusA + radiusB) * calcS(radiusA, radiusB, height)))
    }
    fun volumeConeCut(radiusA:Double, radiusB:Double, height:Double):String{
        return two_Decimals(((PI * height) * (radiusA.pow(2) + radiusA * radiusB + radiusB.pow(2))) / 3)
    }
    fun calcS(A:Double, B:Double, height: Double):Double{
        return sqrt((B - A).pow(2) + height.pow(2))
    }

    //  Cylinder Functions
    fun totalAreaCylinder(radius:Double, height:Double):String{
        val totalArea = lateralAreaCylinder(radius, height).toDouble()
        return two_Decimals(totalArea + (2 * PI * radius.pow(2)))
    }
    fun lateralAreaCylinder(radius:Double, height:Double):String{
        return (2 * PI * radius * height).toString()
    }
    fun volumeCylinder(radius:Double, height:Double):String{
        return two_Decimals(PI * radius.pow(2) * height)
    }

    //  Sfere Functions
    fun totalAreaSfere(radius:Double):String{
        return two_Decimals(4 * PI * radius.pow(2))
    }
    fun volumeSfere(radius:Double):String{
        return two_Decimals((4 * PI * radius.pow(3)) / 3)
    }

    //  SphereCap Functions
    fun totalAreaSphereCap(radius:Double, height:Double):String{
        return two_Decimals(lateralAreaSphereCap(radius, height).toDouble() + (PI * radius.pow(2)))
    }
    fun lateralAreaSphereCap(radius:Double, height:Double):String{
        return (PI * (radius.pow(2) + height.pow(2))).toString()
    }
    fun volumeSphereCap(radius:Double, height:Double):String{
        return two_Decimals((PI * height.pow(2)) * (radius - (height / 3)))
        //return two_Decimals(((3 * PI) * (height) * (radius.pow(2) + height.pow(3))) / 6)
    }

    //  SphereSegment Functions
    fun volumeSphereSegment(radiusA:Double, radiusB: Double, height:Double):String{
        return two_Decimals(((PI * height.pow(3)) / 6) + PI * ((radiusA.pow(2) + radiusB.pow(2)) / 2) * height)
    }

    //  Ellipsoid Functions
    fun totalAreaEllipsoid(radiusA:Double, radiusB: Double, radiusC:Double):String{
        val p = 1.6075
        return two_Decimals(4 * PI * (((radiusA.pow(p) * radiusB.pow(p)) + (radiusA.pow(p) * radiusC.pow(p)) + (radiusB.pow(p) * radiusC.pow(p))) / 3).pow(1 / p))
    }
    fun volumeEllipsoid(radiusA:Double, radiusB: Double, radiusC: Double):String{
        return two_Decimals((4 * PI * radiusA * radiusB * radiusC) / 3)
    }
    fun two_Decimals(value: Double):String{
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        val formating = dec.format(number)
        return formating
    }
}