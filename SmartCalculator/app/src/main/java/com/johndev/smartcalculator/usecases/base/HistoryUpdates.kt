package com.johndev.smartcalculator.usecases.base

data class HistoryUpdates(val id: Int, val version: String, val descriptionFunctionUpdates: MutableList<DescriptionUpdates>,
    val descriptionFormulasUpdates: MutableList<DescriptionUpdates>,
    val descriptionOtherUpdates: MutableList<DescriptionUpdates>)
