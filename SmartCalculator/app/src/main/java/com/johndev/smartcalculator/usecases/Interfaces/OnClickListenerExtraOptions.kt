package com.johndev.smartcalculator.usecases.Interfaces

import android.view.View
import com.johndev.smartcalculator.usecases.base.ExtraOptions

interface OnClickListenerExtraOptions {

    fun onClick(functionalities: ExtraOptions, imgPhoto: View, tvNombre: View)
}