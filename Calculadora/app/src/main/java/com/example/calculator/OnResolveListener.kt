package com.example.calculator
/****
 * Project: Calculator
 * From: https://johnmorales26.github.io/portafolio/html/index.html
 * Created by Jonatan Arturo Morales Tavera on 4/08/21 at 07:13 PM
 * All rights reserved 2021.
 ***/
interface OnResolveListener {
    fun onShowResult(result: Double)
    fun onShowMessage(errorRes: Int)
}