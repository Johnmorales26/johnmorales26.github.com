package com.johndev.neurontraining

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.johndev.neurontraining.Adapters.OnboardingAdapter
import com.johndev.neurontraining.Interfaces.OnDataPassPager
import com.johndev.neurontraining.OnboardingPages.InfDatasetFragment
import com.johndev.neurontraining.OnboardingPages.InfGraphicsFragment
import com.johndev.neurontraining.OnboardingPages.InfOperationsFragment
import com.johndev.neurontraining.OnboardingPages.InfResultsFragment
import com.johndev.neurontraining.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity(), OnDataPassPager {

    private lateinit var binding: ActivityOnboardingBinding
    private val key = "MY_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureViewPager()
        configureOnboarding()
        configureButtons()
        if (binding.viewpager.currentItem == 4) {
            binding.btnNext.visibility = GONE
            binding.btnPrevius.visibility = GONE
            binding.btnLoadApp.visibility = VISIBLE
        } else {
            binding.btnLoadApp.visibility = GONE
            binding.btnNext.visibility = VISIBLE
            binding.btnPrevius.visibility = VISIBLE
        }
    }

    private fun configureButtons() {
        binding.btnNext.setOnClickListener {
            binding.viewpager.setCurrentItem(getItem(+1), true)
        }
        binding.btnPrevius.setOnClickListener {
            binding.viewpager.setCurrentItem(getItem(-1), true)
        }
    }

    private fun getItem(i: Int): Int {
        return binding.viewpager.currentItem + i
    }

    private fun configureOnboarding() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val myPref = prefs.getInt(key, 0)
        if (myPref == 0) {
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun configureViewPager() {
        // setting up the adapter
        val onboardingAdapter = OnboardingAdapter(supportFragmentManager)
        // add the fragments
        onboardingAdapter.add(
            InfDatasetFragment(),
            getString(R.string.onboarding_page_one)
        )
        onboardingAdapter.add(
            InfOperationsFragment(),
            getString(R.string.onboarding_page_two)
        )
        onboardingAdapter.add(
            InfResultsFragment(),
            getString(R.string.onboarding_page_three)
        )
        onboardingAdapter.add(
            InfGraphicsFragment(),
            getString(R.string.onboarding_page_four)
        )
        // Set the adapter
        binding.viewpager.adapter = onboardingAdapter
        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        //binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

    override fun onDataPass(data: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = prefs.edit()
        editor.putInt(key, data)
        editor.apply()
    }
}