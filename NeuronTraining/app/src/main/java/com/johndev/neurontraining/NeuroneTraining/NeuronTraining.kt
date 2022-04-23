package NeuronTraining

import kotlin.math.pow

class NeuronTraining {

    private var alpha = 0.002

    fun resolveGuess(valuesX: MutableList<Float>, w: Float, b: Float): MutableList<Float>{
        val size = valuesX.size
        var i = 0
        val guess: MutableList<Float> = mutableListOf()
        while (i < size){
            val result = (w * valuesX[i]) + b
            guess.add(result)
            i++
        }
        return guess
    }

    fun resolveError(guess: MutableList<Float>, valuesY: MutableList<Float>): MutableList<Float>{
        val size = valuesY.size
        var i = 0
        val errorC: MutableList<Float> = mutableListOf()
        while (i < size){
            val result = (valuesY[i] - guess[i]).pow(2)
            errorC.add(result)
            i++
        }
        return errorC
    }

    fun resolveW(w: Float, result: Float): Float = (w - (alpha * result)).toFloat()

    fun resolveDerivative(w: Float, b: Float, valuesX: MutableList<Float>, valuesY: MutableList<Float>): Float{
        var countResult = 0.0f
        var counter = 0
        while (counter < valuesX.size){
            countResult += (valuesX[counter] * (valuesX[counter] * w + b - valuesY[counter]))
            counter++
        }
        val size = valuesX.size.toString()
        val numerator = 1 / size.toFloat()
        return (numerator * countResult)
    }

    fun resolveCost(w: Float, valuesX: MutableList<Float>, valuesY: MutableList<Float>): Float{
        var countResult = 0.0f
        var counter = 0
        while (counter < valuesX.size){
            countResult += (valuesY[counter] - ((w * valuesX[counter]) + 32)).pow(2)
            counter++
        }
        val size = valuesX.size.toString()
        val numerator = 1 / (size.toFloat() * 2)
        return (numerator * countResult)
    }

}