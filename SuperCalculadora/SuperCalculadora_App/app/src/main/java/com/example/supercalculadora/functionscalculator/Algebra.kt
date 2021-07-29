package com.example.supercalculadora.functionscalculator

import android.os.Parcel
import android.os.Parcelable
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

class Algebra(){
    constructor(parcel: Parcel) : this() {
    }

    //      First Screen
    //  Percent
    fun discountTotal(valueA: Double, valueB: Double): String {
        return (valueA - ((valueA * valueB) / 100)).toString()
    }

    fun Operationdiscount(valueA: Double, valueB: Double): String {
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
        return two_Decimals((valueA * 100) / valueB)
    }

    fun percentOfAsinceBOperation(valueA: Double, valueB: Double): String {
        val result = two_Decimals((valueA * 100) / valueB)
        return ("x = ((${valueA} * 100) / ${valueB}) \n\n " +
                "x = ((${valueA * 100}) / ${valueB}) \n\n" +
                "x = $result")
    }

        //      Second Screen
        //  Arithmetic
        fun arithmetic(valueA: Double, valueB: Double): String {
            return ((valueA + valueB) / 2).toString()
        }

        //  Geometric
        fun geometric(valueA: Double, valueB: Double): String {
            return (sqrt(valueA * valueB)).toString()
        }

        //  Harmonic
        fun harmonic(valueA: Double, valueB: Double): String {
            return (2 / ((1 / valueA) + (1 / valueB))).toString()
        }

        //  Proportion
        fun directlyProportional(valueA: Double, valueB: Double, valueX: Double): String {
            return ((valueB * valueX) / valueA).toString()
        }

        fun indirectlyProportional(valueA: Double, valueB: Double, valueX: Double): String {
            return ((valueA * valueB) / valueX).toString()
        }

        //      Fourth Screen
        //  linealEcuation
        fun linealEquation(valueA: Double, valueB: Double): String {
            val signChange = "-$valueB"
            return (signChange.toDouble() / valueA).toString()
        }

        fun squareRoot(valueA: Double, valueB: Double, valueC: Double): Double {
            return sqrt((valueB.pow(2)) - (4 * valueA * valueC))
        }

        fun quadraticEquationPositive(valueA: Double, valueB: Double, valueC: Double): String {
            return ((-(valueB) + squareRoot(valueA, valueB, valueC)) / (2 * valueA)).toString()
        }

        fun quadraticEquationNegative(valueA: Double, valueB: Double, valueC: Double): String {
            return ((-(valueB) - squareRoot(valueA, valueB, valueC)) / (2 * valueA)).toString()
        }

        //  Fractions -> Pendient
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
        /*fun primeNumbers(value : Int): String {
        val productoria = 1
        val c_value = value
        val f_primo = 2
        do {
            val resto = c_value % f_primo
            if (resto == 0) {
                println("%d", $(f_primo));
                cc_value /= f_primo
            } else
                factor_primo = siguiente_primo(factor_primo);
        } while (productoria != n);
    }

    fun nextPrimeNumbers(value: Int): String{
        var nextPrimeNumber = value
            do {
                nextPrimeNumber++;
            } while (primeNumbers(nextPrimeNumber) == "No");
            return nextPrimeNumber.toString()
    }*/
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
    private fun two_Decimals(value: Double):String{
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        val formating = dec.format(number)
        return formating
    }
    }
