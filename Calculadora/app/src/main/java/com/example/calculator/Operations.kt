package com.example.calculator
/****
 * Project: Calculator
 * From: https://johnmorales26.github.io/portafolio/html/index.html
 * Created by Jonatan Arturo Morales Tavera on 4/08/21 at 07:13 PM
 * All rights reserved 2021.
 ***/
class Operations {

    companion object{
        fun getOperator(operation: String): String {
            var operator = if (operation.contains(Constantes.OPERATOR_MULTI)){
                Constantes.OPERATOR_MULTI
            } else if (operation.contains(Constantes.OPERATOR_DIV)){
                Constantes.OPERATOR_DIV
            } else if (operation.contains(Constantes.OPERATOR_SUM)){
                Constantes.OPERATOR_SUM
            } else {
                Constantes.OPERATOR_NULL
            }

            if (operator == Constantes.OPERATOR_NULL && operation.lastIndexOf(Constantes.OPERATOR_REST) > 0){
                operator = Constantes.OPERATOR_REST
            }

            return operator
        }

        fun canReplaceOperator(charSequence: CharSequence): Boolean {
            if (charSequence.length < 2) return false

            val lastElement = charSequence[charSequence.length - 1].toString()
            val penultimateElement = charSequence[charSequence.length - 2].toString()

            return (lastElement == Constantes.OPERATOR_MULTI ||
                    lastElement == Constantes.OPERATOR_DIV ||
                    lastElement == Constantes.OPERATOR_SUM) &&
                    (penultimateElement == Constantes.OPERATOR_MULTI ||
                            penultimateElement == Constantes.OPERATOR_DIV ||
                            penultimateElement == Constantes.OPERATOR_SUM ||
                            penultimateElement == Constantes.OPERATOR_REST)
        }

        fun tryResolve(operationRef: String, isFromResolve: Boolean, listener: OnResolveListener) {
            if (operationRef.isEmpty()) return

            var operation = operationRef
            if (operation.contains(Constantes.OPERATOR_POINT) && operation.lastIndexOf(Constantes.OPERATOR_POINT) == operation.length - 1){
                operation = operation.substring(0, operation.length - 1)
            }

            val operator = getOperator(operation)
            val values = divideOperation(operator, operation)

            if (values.size > 1) {
                try {
                    val numberOne = values[0]!!.toDouble()
                    val numberTwo = values[1]!!.toDouble()

                    listener.onShowResult(getResult(numberOne, operator, numberTwo))
                } catch (e: NumberFormatException){
                    if (isFromResolve) listener.onShowMessage(R.string.message_num_incorrect)
                }
            } else {
                if (isFromResolve && operator != Constantes.OPERATOR_NULL)
                    listener.onShowMessage(R.string.message_exp_incorrect)
            }
        }

        fun divideOperation(operator: String, operation: String): Array<String?> {
            var values = arrayOfNulls<String>(0)
            if (operator != Constantes.OPERATOR_NULL) {
                if (operator == Constantes.OPERATOR_REST){
                    val index = operation.lastIndexOf(Constantes.OPERATOR_REST)
                    if (index < operation.length-1){
                        values = arrayOfNulls(2)
                        values[0] = operation.substring(0, index)
                        values[1] = operation.substring(index+1)
                    } else {
                        values = arrayOfNulls(1)
                        values[0] = operation.substring(0, index)
                    }
                } else {
                    values = operation.split(operator).dropLastWhile { it == "" }.toTypedArray()
                }
            }
            return values
        }

        private fun getResult(numberOne: Double, operator: String, numberTwo: Double): Double{
            return when(operator){
                Constantes.OPERATOR_MULTI -> numberOne * numberTwo
                Constantes.OPERATOR_DIV -> numberOne / numberTwo
                Constantes.OPERATOR_SUM -> numberOne + numberTwo
                else -> numberOne - numberTwo //Constants.OPERATOR_RES
            }
        }
    }
}