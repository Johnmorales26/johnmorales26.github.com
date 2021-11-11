package com.johndev.smartcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.johndev.smartcalculator.databinding.ActivitySplashBinding

import com.tomer.fadingtextview.FadingTextView

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val time:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texts = arrayOf(getString(R.string.splash_screen_loading_1),
            getString(R.string.splash_screen_loading_2),
            getString(R.string.splash_screen_loading_3),
            getString(R.string.splash_screen_loading_1),
            getString(R.string.splash_screen_loading_2),
            getString(R.string.splash_screen_loading_3))
        binding.fadingTextView.setTexts(texts) //You can use an array resource or a string array as the parameter


        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, time)

    }
}