package com.johndev.smartcalculator.usecases.common

import android.content.Context
import java.lang.Math.*
import java.text.DecimalFormat
import kotlin.math.pow

class FunctionsAlgebra(val context: Context) {
    
    val viewDecimals = ViewDecimals(context)
    
    //      First Screen
    //  Percent
    fun discountTotal(valueA: Double, valueB: Double): String {
        return (valueA - ((valueA * valueB) / 100)).toString()
    }

    fun operationDiscount(valueA: Double, valueB: Double): String {
        val result = ((valueA * valueB) / 100)
        return ("x = ${valueA} - ((${valueA} * ${valueB}) / 100) \n\nx = ${valueA} - (${valueA * valueB} / 100)" +
                "\n\nx = ${valueA} - ${(valueA * valueB) / 100} \n\nx = ${result}")
    }

    fun discountPercent(valueA: Double, valueB: Double): String {
        return (((valueA * valueB) / 100)).toString()
    }

    //  Increment
    fun percentIncrement(valueA: Double, valueB: Double): String {
        return ((valueA * valueB) / 100).toString()
    }

    fun Operationincrement(valueA: Double, valueB: Double): String {
        val result = (valueA + percentIncrement(valueA, valueB).toDouble())
        return ("x = ${valueA} + ((${valueA} * ${valueB}) / 100) \n\nx = ${valueA} + (${valueA * valueB} / 100)" +
                "\n\nx = ${valueA} + ${(valueA * valueB) / 100} \n\nx = ${result}")
    }

    fun incrementTotal(valueA: Double, valueB: Double): String {
        return (valueA + percentIncrement(valueA, valueB).toDouble()).toString()
    }

    //  Simple Percent
    fun simplePercent(valueA: Double, valueB: Double): String {
        return ((valueA * valueB) / 100).toString()
    }

    fun simplePercentOperation(valueA: Double, valueB: Double): String {
        val result = ((valueA * valueB) / 100)
        return ("x = ${valueA} * .${valueB} \n\n x = ${result}")
    }

    //  Increment / Decrement
    fun incrementAndDecrement(valueA: Double, valueB: Double): String {
        return (((valueB * 100) / valueA) - 100).toString()
    }

    fun incrementAndDecrementOperation(valueA: Double, valueB: Double): String {
        val result = (((valueB * 100) / valueA) - 100)
        return ("x = ((${valueA} * ${valueB}) / 1000) - 100 \n\n " +
                "x = ((${valueA * valueB}) / 1000) - 100 \n\n" +
                "x = ${(valueA * valueB) / 1000} - 100 \n\n" +
                "x = $result")
    }

    //  Percent of A since B
    fun percentOfAsinceB(valueA: Double, valueB: Double): String {
        return viewDecimals.selectedDecimals((valueA * 100) / valueB)
    }

    fun percentOfAsinceBOperation(valueA: Double, valueB: Double): String {
        val result = viewDecimals.selectedDecimals((valueA * 100) / valueB)
        return ("x = ((${valueA} * 100) / ${valueB}) \n\n " +
                "x = ((${valueA * 100}) / ${valueB}) \n\n" +
                "x = $result")
    }

    //      Second Screen
    //  Arithmetic
    fun arithmetic(valueA: Double, valueB: Double): Double {
        return ((valueA + valueB) / 2)
    }
    fun arithmeticOperations(valueA: Double, valueB: Double): String {
        return ("Arithmetic \n" +
                "($valueA + $valueB) / 2 \n " +
                "${valueA + valueB} / 2 \n " +
                arithmetic(valueA, valueB))
    }

    //  Geometric
    fun geometric(valueA: Double, valueB: Double): Double {
        return (2 / ((1 / valueA) + (1 / valueB)))
    }
    fun geometricOperations(valueA: Double, valueB: Double): String {
        return ("Geometric \n" +
                "√$valueA * $valueB \n" +
                "√${valueA * valueB} \n" +
                geometric(valueA, valueB))
    }

    //  Harmonic
    fun harmonic(valueA: Double, valueB: Double): Double {
        return (2 / ((1 / valueA) + (1 / valueB)))
    }
    fun harmonicOperations(valueA: Double, valueB: Double): String {
        return ("Harmonic \n" +
                "2 / (1 / $valueA) + (1 / $valueB) \n" +
                "2 / (${1 / valueA}) + (${1 / valueB}) \n" +
                "2 / (${(1 / valueA) + (1 / valueB)}) \n" +
                harmonic(valueA, valueB))
    }
    fun averageOperations(valueA: Double, valueB: Double): String{
        val arithmetic = arithmeticOperations(valueA, valueB)
        val geometric = geometricOperations(valueA, valueB)
        val harmonic = harmonicOperations(valueA, valueB)
        return "$arithmetic \n\n $geometric \n\n $harmonic"
    }
    //  Proportion
    fun directlyProportional(valueA: Double, valueB: Double, valueX: Double): String {
        return viewDecimals.selectedDecimals(((valueB * valueX) / valueA))
    }

    fun indirectlyProportional(valueA: Double, valueB: Double, valueX: Double): String {
        val result = ((valueA * valueB) / valueX)
        return viewDecimals.selectedDecimals(result)
    }

    //      Fourth Screen
    //  linealEcuation
    fun linealEquation(valueA: Double, valueB: Double): String {
        val signChange = "-$valueB"
        return viewDecimals.selectedDecimals(signChange.toDouble() / valueA)
    }
    fun linealEquationOperation(valueA: Double, valueB: Double): String {
        return "${valueA}x + ${valueB} = 0"
    }

    fun squareRoot(valueA: Double, valueB: Double, valueC: Double): Double {
        return sqrt((valueB.pow(2)) - (4 * valueA * valueC))
    }

    fun quadraticEquationPositive(valueA: Double, valueB: Double, valueC: Double): String {
        return viewDecimals.selectedDecimals((-(valueB) + squareRoot(valueA, valueB, valueC)) / (2 * valueA))
    }

    fun quadraticEquationOperation(valueA: Double, valueB: Double, valueC: Double): String {
        return "${valueA}x² + ${valueB}x + $valueC = 0"
    }

    fun quadraticEquationNegative(valueA: Double, valueB: Double, valueC: Double): String {
        return viewDecimals.selectedDecimals((-(valueB) - squareRoot(valueA, valueB, valueC)) / (2 * valueA))
    }

    //  Fractions
    fun simplifyFractions(numerator: Long, denominator: Long): MutableMap<String, Long> {
        val MCD = MCD(numerator, denominator).toInt()
        val num = numerator / MCD
        val den = denominator / MCD
        val fraction: MutableMap<String, Long> = mutableMapOf("Numerator" to num, "Denominator" to den)
        return fraction
    }

    //  Decimal To Fraction
    fun decimalToFraction(decimal: Double): MutableMap<String, Double> {
        var valueA: Double = 1.0
        var valueB: Double = 1.0
        var auxiliar: Double = 1.0
        while (auxiliar != decimal) {
            auxiliar = valueA / valueB
            if (auxiliar < decimal) {
                valueA++
            } else if (auxiliar > decimal) {
                valueA--
                valueB++
            }
        }
        return mutableMapOf("Numerator" to valueA, "Denominator" to valueB)
    }

    //differentiateIntegerAndDecimal
    fun differentiateIntegerAndDecimal(numberDouble: Double): String{
        var numberInt: Int = numberDouble.toInt()
        val result = numberDouble - numberInt
        return if (result == 0.0){
            numberInt.toString()
        }else{
            numberDouble.toString()
        }
    }

    //  MCD / MCM
    fun MCD(valueA: Long, valueB: Long): String {
        if (valueB.toString() == "0") return valueA.toString()
        return MCD(valueB, valueA % valueB)
    }

    fun Max(valueA: Long, valueB: Long): Long {
        return if (valueA >= valueB) {
            valueA
        } else {
            valueB
        }
    }

    fun Min(valueA: Long, valueB: Long): Long {
        return if (valueA <= valueB) {
            valueA
        } else {
            valueB
        }
    }

    fun MCM(valueA: Long, valueB: Long): Long {
        val a = Max(valueA, valueB)
        val b = Min(valueA, valueB)
        return ((a / MCD(a, b).toLong()) * b)
    }

    fun factorial(num: Long): Long {
        var factorial: Long = 1
        for (i in 1..num) {
            factorial *= i
        }
        return factorial
    }

    //  Combinations
    fun combinationWithOrganizedAndRepeated(NoElements: Double, size: Int): String {
        return ((NoElements.pow(size)).toInt()).toString()
    }

    fun combinationWithRepeated(NoElements: Double, size: Int): String {
        return ((factorial((NoElements + size - 1).toLong())) / ((factorial(size.toLong())) * (factorial(
            (NoElements - 1).toLong()
        )))).toString()
    }

    fun combinationWithOrganized(NoElements: Double, size: Int): String {
        return ((factorial(NoElements.toLong())) / (factorial((NoElements - size).toLong()))).toString()
    }

    fun combination(NoElements: Double, size: Int): String {
        val part1 = factorial(NoElements.toLong())
        val part2 = (factorial(size.toLong()) * factorial((NoElements - size).toLong()))
        return (part1 / part2).toString()
    }

    //  Prime Numbers

    fun isPrimeNumber(value: Int): String{
        var divisiones = 1
        var residuo = 0
        do {
            if (value % divisiones == 0){
                residuo++
            }
            divisiones++
        }while (divisiones <= value)
        return if (residuo == 2){
            "Si"
        }else{
            "No"
        }
    }

    fun Factores_Primos(number: Int): String{
        var c_number = number.toInt()
        var i = 2
        var  primeFactors: MutableList<String> = mutableListOf()
        while (c_number > 1){
            var contador = 0
            while (c_number % i == 0){
                contador++
                c_number = c_number / i
                if (c_number % i != 0){
                    if (contador > 1){
                        primeFactors.add("$i" + "^" + contador)
                    }
                    else if (c_number > 1){
                        primeFactors.add("${i}" + "^1")
                    }
                    else{
                        primeFactors.add(i.toString())
                    }
                }
            }
            i++
        }
        return primeFactors.toString()
    }
    fun primeFactorPrint(text: String): String{
        var primeFactor = Factores_Primos(text.toInt())
        primeFactor = primeFactor.replace(",", " x ")
        primeFactor = primeFactor.replace("[", "")
        primeFactor = primeFactor.replace("]", "")
        return primeFactor
    }

    fun nextPrime(n: Int): Int {
        var n = n
        do {
            n++
        } while (isPrime(n) == 0)
        return n
    }

    fun isPrime(n: Int): Int {
        if (n <= 0) return 0
        var cant_divisores = 0
        var encontro_divisores = 0
        val limite = sqrt(n.toDouble()).toInt()
        var i = 2
        while (i <= limite && encontro_divisores == 0) {
            if (n % i == 0) {
                cant_divisores++
                encontro_divisores = 1
            }
            i++
        }
        return if (cant_divisores > 0 || n == 1) 0 else 1
    }

    //  Random Values
    fun random(valueA: Int, valueB: Int, numberValues: Int): String {
        var i = 1
        val lista: MutableList<String> = mutableListOf()
        if (numberValues > 0) {
            while (i <= numberValues) {
                lista.add(((valueA..valueB).random()).toString())
                i++
            }
            return lista.toString()
        } else {
            return "Valor No Generado"
        }
        return lista.toString()
    }
    
}