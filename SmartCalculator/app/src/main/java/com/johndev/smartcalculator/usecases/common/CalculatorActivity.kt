package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.johndev.smartcalculator.databinding.ActivityCalculatorBinding
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.usecases.Interfaces.OnResolveListener
import com.johndev.smartcalculator.usecases.base.OperationsCalculator
import java.util.*

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvOperation.run {
            addTextChangedListener { charSequence ->
                if (OperationsCalculator.canReplaceOperator(charSequence.toString())){
                    val newStr = "${text.substring(0, text.length - 2)}${text.substring(text.length - 1)}"
                    text = newStr
                }
            }
        }
    }

    fun onClickButton(view: View){
        val valueStr = (view as Button).text.toString()
        val operation = binding.tvOperation.text.toString()

        when(view.id){
            R.id.btnDelete -> {
                binding.tvOperation.run {
                    if (text.length > 0) text = operation.substring(0, text.length-1)
                }
            }
            R.id.btnClear -> {
                binding.tvOperation.text = ""
                binding.tvResult.text = ""
            }
            R.id.btnResult -> checkOrResolve(operation, true)

            R.id.btnMul,
            R.id.btnDiv,
            R.id.btnSum,
            R.id.btnResult -> {
                checkOrResolve(operation, false)

                addOperator(valueStr, operation)
            }
            R.id.btnPoint -> addPoint(valueStr, operation)

            else -> binding.tvOperation.append(valueStr)
        }
    }

    private fun addPoint(pointStr: String, operation: String) {
        if (!operation.contains(Constantes.OPERATOR_POINT)){
            binding.tvOperation.append(pointStr)
        } else {
            val operator = OperationsCalculator.getOperator(operation)
            val values = OperationsCalculator.divideOperation(operator, operation)

            if (values.size > 0){
                val numberOne = values[0]!!
                if (values.size > 1){
                    val numberTwo = values[1]!!
                    if (numberOne.contains(Constantes.OPERATOR_POINT) && !numberTwo.contains(Constantes.OPERATOR_POINT)){
                        binding.tvOperation.append(pointStr)
                    }
                } else {
                    if (numberOne.contains(Constantes.OPERATOR_POINT)){
                        binding.tvOperation.append(pointStr)
                    }
                }
            }
        }
    }

    private fun addOperator(operator: String, operation: String) {
        val lastElement = if (operation.isEmpty()) ""
        else operation.substring(operation.length - 1)

        if (operator == Constantes.OPERATOR_REST){
            if (operation.isEmpty() || lastElement != Constantes.OPERATOR_REST && lastElement != Constantes.OPERATOR_POINT){
                binding.tvOperation.append(operator)
            }
        } else {
            if (!operation.isEmpty() && lastElement != Constantes.OPERATOR_POINT){
                binding.tvOperation.append(operator)
            }
        }
    }

    private fun checkOrResolve(operation: String, isFromResolve: Boolean){
        OperationsCalculator.tryResolve(operation, isFromResolve, object : OnResolveListener {
            override fun onShowResult(result: Double) {
                binding.tvResult.text = String.format(Locale.ROOT, "%.2f", result)

                if (binding.tvResult.text.isNotEmpty() && !isFromResolve){
                    binding.tvOperation.text = binding.tvResult.text
                }
            }

            override fun onShowMessage(errorRes: Int) {
                showMessage(errorRes)
            }
        })
    }

    private fun showMessage(errorRes: Int){
        Snackbar.make(binding.root, errorRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.llTop)
            .show()
    }
}