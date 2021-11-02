package com.johndev.smartcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.johndev.smartcalculator.databinding.ActivityMainBinding
import com.johndev.smartcalculator.usecases.common.CalculatorActivity
import com.johndev.smartcalculator.usecases.home.MainAlgebraFragment
import com.johndev.smartcalculator.usecases.home.MainExtraOptionsFragment
import com.johndev.smartcalculator.usecases.home.MainFormulasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_functions -> {
                    val fragment = MainAlgebraFragment()
                    openFragment(fragment)
                    true
                }
                R.id.action_formulas -> {
                    val fragment = MainFormulasFragment()
                    openFragment(fragment)
                    true
                }
                R.id.action_extra_options -> {
                    val fragment = MainExtraOptionsFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.action_functions

        binding.fab.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

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
        private const val RC_EDIT = 21
    }

}