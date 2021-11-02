package com.johndev.smartcalculator.usecases.base

data class OperationHistory(
    //  Obligatory Data
    var id: Long = 0,
    var nameFigure: String = "",
    var image: Int = 0,
    //  Optional Data
    var sideA: Double? = null,
    var sideB: Double? = null,
    var sideC: Double? = null,
    var height: Double? = null,
    var width: Double? = null,
    var radiusA: Double? = null,
    var radiusB: Double? = null,
    var radiusC: Double? = null,
    var angleA: Double? = null,
    // Variables for results
    var angleAB: String? = null,
    var angleBC: String? = null,
    var angleAC: String? = null,
    var heightA: String? = null,
    var heightB: String? = null,
    var heightC: String? = null,
    var area: String? = null,
    var perimeter: String? = null,
    var lateralArea: String? = null,
    var volume: String? = null){}
