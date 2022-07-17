package com.johndev.smartcalculator

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.johndev.smartcalculator.databinding.ActivitySettingsBinding
import com.johndev.smartcalculator.usecases.Settings.SettingsFragment

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setupToolbar()
        setupFragment()
    }

    override fun onResume() {
        super.onResume()
        configureTheme()
    }

    private fun setupFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_introduction, SettingsFragment())
            .commit()
    }

    private fun setupToolbar() {
        binding.topAppBar.title = getString(R.string.settings_title)
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
            getString(R.string.preference_key_color_default) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_red) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryRedColor)))
            }
            getString(R.string.preference_key_color_yellow) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryYellowColor)))
            }
            getString(R.string.preference_key_color_blue) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryBlueColor)))
            }
            getString(R.string.preference_key_color_green) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryGreenColor)))
            }
            getString(R.string.preference_key_color_purple) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_orange) -> {
                binding.topAppBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryOrangeColor)))
            }
        }
    }

}