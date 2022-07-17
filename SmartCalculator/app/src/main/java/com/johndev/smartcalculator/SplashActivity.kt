package com.johndev.smartcalculator

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.johndev.smartcalculator.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    lateinit var sharedPreferences: SharedPreferences
    private var handler = Handler()
    private var isActive = false
    private var value = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        configureTheme()
        setContentView(binding.root)
        loadProgressBar()
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
                getString(R.string.preference_key_color_default) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryPurpleColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_red) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryRedColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_yellow) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryYellowColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_blue) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryBlueColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_green) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryGreenColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_purple) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryPurpleColor), PorterDuff.Mode.SRC)
                }
                getString(R.string.preference_key_color_orange) -> {
                    binding.container.background.setColorFilter(Color.parseColor(ColorsExtra.primaryOrangeColor), PorterDuff.Mode.SRC)
                }
        }
    }

    private fun loadProgressBar() {
        var progress = 0
        if (!isActive) {
            val thread = Thread(Runnable {
                kotlin.run {
                    while (progress <= 100) {
                        handler.post(Runnable {
                            kotlin.run {
                                binding.tvChargePercent.text = "$progress%"
                                binding.progressBar.progress = progress
                            }
                        })
                        try {
                            Thread.sleep(30)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                        if (progress == 100) {
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        progress++
                        isActive = true
                    }
                }
            })
            thread.start()
        }
    }

}