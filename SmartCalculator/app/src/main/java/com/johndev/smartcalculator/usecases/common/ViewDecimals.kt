package com.johndev.smartcalculator.usecases.common

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.R

class ViewDecimals(val context: Context) {

    private lateinit var sharedPreferences: SharedPreferences

    fun selectedDecimals(value: Double): String {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return when(sharedPreferences.getString(context.getString(R.string.preferences_key_number_of_decimals),
            "").toString()) {
            "pref_two_decimals" -> roundTwoDecimals(value)
            "pref_four_decimals" -> roundFourDecimals(value)
            "pref_six_decimals" -> roundSixDecimals(value)
            "pref_eight_decimals" -> roundEightDecimals(value)
            else -> "ERROR!!"
        }
    }

    private fun roundTwoDecimals(number: Double): String = String.format("%.2f", number)

    private fun roundFourDecimals(number: Double): String = String.format("%.4f", number)

    private fun roundSixDecimals(number: Double): String = String.format("%.6f", number)

    private fun roundEightDecimals(number: Double): String = String.format("%.8f", number)

}