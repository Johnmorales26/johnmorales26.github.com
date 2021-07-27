package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickButton(view: View){
        val valueStr = (view as Button).text.toString()
        when(view.id){
            R.id.btnDelete -> {
                val length = binding.tvOperation.text.length
                if (length > 0){
                    val newOperations = binding.tvOperation.text.toString().substring(0, length-1)
                    binding.tvOperation.text = newOperations
                }
            }
            R.id.btnClear -> {
                binding.tvOperation.text = ""
                binding.tvResult.text = ""
            }
            R.id.btnResult -> {
                tryResolve(binding.tvOperation.text.toString())
            }
            else -> {
                binding.tvOperation.append(valueStr)
            }
        }
    }

    private fun tryResolve(operationRef: String) {
        val operator = getOperator(operationRef)
        var values = arrayOfNulls<String>(0)
        values = operationRef.split(operator).toTypedArray()
        val numberOne = values[0]!!.toDouble()
        val numberTwo = values[1]!!.toDouble()
        binding.tvResult.text = getResult(numberOne, operator, numberTwo).toString()
    }

    private fun getOperator(operation: String): String {
        var operator = ""
        if (operation.contains(OPERATOR_MULTI)){
            operator = OPERATOR_MULTI
        } else if (operation.contains(OPERATOR_DIV)){
            operator = OPERATOR_DIV
        }else if (operation.contains(OPERATOR_REST)){
            operator = OPERATOR_REST
        }else if (operation.contains(OPERATOR_SUM)){
            operator = OPERATOR_SUM
        }
        return operator
    }
    fun getResult(numberOne: Double, operator: String, numberTwo: Double): Double{
        var result = 0.0
        when(operator){
            OPERATOR_MULTI -> result = numberOne * numberTwo
            OPERATOR_DIV -> result = numberOne / numberTwo
            OPERATOR_SUM -> result = numberOne + numberTwo
            OPERATOR_REST -> result = numberOne - numberTwo
        }
        return result
    }
    companion object{
        const val OPERATOR_MULTI = "*"
        const val OPERATOR_DIV = "/"
        const val OPERATOR_REST = "-"
        const val OPERATOR_SUM = "+"
        const val OPERATOR_NULL = "null"
        const val OPERATOR_POINT = "."
    }
}