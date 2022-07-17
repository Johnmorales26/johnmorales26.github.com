package com.johndev.smartcalculator.usecases.Settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.johndev.smartcalculator.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferenes, rootKey)
    }

}