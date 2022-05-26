package com.johndev.neurontraining

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.johndev.neurontraining.Interfaces.OnDatasetListener
import com.johndev.neurontraining.MainViews.*
import com.johndev.neurontraining.MainViews.CalculationsAutomaticFragment.Companion.resultsAutomatic
import com.johndev.neurontraining.MainViews.CalculationsFragment.Companion.resultsPerceptron
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.dataset
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesX
import com.johndev.neurontraining.MainViews.ChargeDataFragment.Companion.valuesY
import com.johndev.neurontraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnDatasetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MainActivity.appContext = applicationContext

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.action_dark_mode -> {
                    val currentNightMode: Int = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                    when (currentNightMode) {
                        Configuration.UI_MODE_NIGHT_NO -> {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            Toast.makeText(this, getString(R.string.toast_dark_mode_actived), Toast.LENGTH_SHORT).show()
                            finish()
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        Configuration.UI_MODE_NIGHT_YES -> {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            Toast.makeText(this, getString(R.string.toast_light_mode_actived), Toast.LENGTH_SHORT).show()
                            finish()
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                    }
                    true
                }
                R.id.action_exit -> {
                    finishAffinity()
                    true
                }
                R.id.action_clear -> {
                    resultsAutomatic = mutableListOf()
                    valuesX = mutableListOf()
                    valuesY = mutableListOf()
                    dataset = mutableListOf()
                    resultsPerceptron = mutableListOf()
                    fragment = supportFragmentManager.findFragmentByTag("Your_Fragment_TAG")!!
                    val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                    ft.detach(fragment)
                    ft.attach(fragment)
                    ft.commit()
                    true
                }
                else -> {
                    super.onOptionsItemSelected(menuItem)
                }
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_introduction -> {
                    fragment = IntroductionFragment()
                    openFragment(fragment)
                    binding.toolbar.title = getString(R.string.main_title_introductions)
                    true
                }
                R.id.action_dataset -> {
                    fragment = ChargeDataFragment()
                    openFragment(fragment)
                    binding.toolbar.title = getString(R.string.main_title_load_data)
                    true
                }
                R.id.action_calculo -> {
                    fragment = CalculationsFragment()
                    openFragment(fragment)
                    binding.toolbar.title = getString(R.string.main_title_calculates)
                    true
                }
                R.id.action_calculo_automatic -> {
                    fragment = CalculationsAutomaticFragment()
                    openFragment(fragment)
                    binding.toolbar.title = getString(R.string.main_title_calculates_automatic)
                    true
                }
                R.id.action_developer -> {
                    fragment = DeveloperFragment()
                    openFragment(fragment)
                    binding.toolbar.title = getString(R.string.main_title_developer)
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.action_introduction
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title_exit)
            .setPositiveButton(R.string.btn_exit) { dialogInterface, i -> finish() }
            .setNegativeButton(getString(R.string.btn_cancelar), null)
            .show()
    }

    companion object{
        lateinit var appContext: Context
    }

}