package com.johndev.smartcalculator.usecases.Interfaces

import com.johndev.smartcalculator.usecases.base.OperationHistory


interface OnClickListenerHistory {
    fun onClick(operationHistory: OperationHistory)
}