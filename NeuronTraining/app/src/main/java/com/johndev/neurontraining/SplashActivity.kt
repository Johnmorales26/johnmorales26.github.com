package com.johndev.neurontraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.johndev.neurontraining.databinding.ActivitySplashBinding

private lateinit var binding: ActivitySplashBinding
private var handler = Handler()
private var isActive = false
private var progress = 0
private var value = 1

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadProgressBar()
    }

    private fun loadProgressBar() {
        if (!isActive) {
            var thread = Thread(Runnable {
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
                            startActivity(Intent(this, OnboardingActivity::class.java))
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