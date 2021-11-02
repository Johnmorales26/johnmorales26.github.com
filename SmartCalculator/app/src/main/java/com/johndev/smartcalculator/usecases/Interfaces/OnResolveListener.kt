package com.johndev.smartcalculator.usecases.Interfaces

interface OnResolveListener {
    fun onShowResult(result: Double)
    fun onShowMessage(errorRes: Int)
}