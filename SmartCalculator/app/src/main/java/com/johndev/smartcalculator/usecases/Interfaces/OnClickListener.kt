package com.johndev.smartcalculator.usecases.Interfaces

import android.view.View
import com.johndev.smartcalculator.usecases.Adapters.SecondaryMenusAdapter
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.base.SecondaryMenus

interface OnClickListener {
    fun onClick(functionalities: Functionalities, imgPhoto: View, tvNombre: View)
    fun onClick(secondaryMenus: SecondaryMenus, imgPhoto: View, tvNombre: View)
    fun onClick(figuresOrBodies: FiguresAndBodies, imgPhoto: View, tvNombre: View)
    fun onClick(formula: Formulas, tvNombre: View)
}