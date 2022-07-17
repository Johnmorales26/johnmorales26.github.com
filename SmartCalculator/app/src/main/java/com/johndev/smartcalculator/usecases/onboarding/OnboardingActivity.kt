package com.johndev.smartcalculator.usecases.onboarding

import android.R
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.databinding.ActivityOnboardingBinding
import com.johndev.smartcalculator.usecases.Adapters.OnboardingAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnDataPass
import com.johndev.smartcalculator.usecases.onboarding.fragments.*


class OnboardingActivity : AppCompatActivity(), OnDataPass {

    private lateinit var binding: ActivityOnboardingBinding
    private val key = "MY_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureViewPager()
        configureOnboarding()
    }

    private fun configureOnboarding() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val myPref = prefs.getInt(key, 0)
        if (myPref == 0){
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun configureViewPager() {
        // setting up the adapter
        val onboardingAdapter = OnboardingAdapter(supportFragmentManager)
        // add the fragments
        onboardingAdapter.add(OnboardingAlgebraFragment(), getString(com.johndev.smartcalculator.R.string.onboarding_page_one))
        onboardingAdapter.add(OnboardingGeometriaFragment(), getString(com.johndev.smartcalculator.R.string.onboarding_page_two))
        onboardingAdapter.add(OnboardingConversionesFragment(), getString(com.johndev.smartcalculator.R.string.onboarding_page_three))
        onboardingAdapter.add(OnboardingOthersFragment(), getString(com.johndev.smartcalculator.R.string.onboarding_page_four))
        onboardingAdapter.add(OnboardingStartFragment(), getString(com.johndev.smartcalculator.R.string.onboarding_page_five))
        // Set the adapter
        binding.viewpager.adapter = onboardingAdapter
        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

    override fun onDataPass(data: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = prefs.edit()
        editor.putInt(key, data)
        editor.apply()
    }
}