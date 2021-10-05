package com.cursosant.android.mdpostres

/****
 * Project: MD Postres
 * From: com.cursosant.android.mdpostres
 * Created by Alain Nicolás Tello on 01/01/21 at 14:06
 * Course: Professional Material Desing/Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * All rights reserved 2021.
 *
 * Others:
 * Android con Kotlin intensivo y práctico desde cero.
 * https://www.udemy.com/course/kotlin-intensivo/?referralCode=93D5D2FA6EF503FD0A6B
 */
class Product(var name: String?, var url: String?) {

    var isSelected = false

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val product = o as Product
        if (isSelected != product.isSelected) return false
        if (if (name != null) name != product.name else product.name != null) return false
        return if (url != null) url == product.url else product.url == null
    }

    override fun hashCode(): Int {
        var result = if (name != null) name.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        result = 31 * result + if (isSelected) 1 else 0
        return result
    }
}