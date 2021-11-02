package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityFormulasBinding
import com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.ContainerPercentFragment

class FormulasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormulasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormulasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))
        with(binding) {
            toolbar.title = nameFunction
        }

        operationSelected(nameFunction)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title_return)
            .setPositiveButton(R.string.btn_return) { dialogInterface, i -> finish() }
            .setNegativeButton(getString(R.string.btn_cancelar), null)
            .show()
    }

    private fun operationSelected(nameFunction: String?) {
        when (nameFunction) {
            getString(R.string.formula_triangle) -> {
                val fragment = FormulaTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_right_triangle) -> {
                val fragment = FormulasShiftTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_square) -> {
                val fragment = FormulaSquareFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_rectangle) -> {
                val fragment = FormulaRectangleFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_parallelogram) -> {
                val fragment = FormulaParalelogramoFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_rhomb) -> {
                val fragment = FormulaRhombFragment()
                openFragment(fragment)
            }
            getString(R.string.formula_trapezoid) -> {
                val fragment = FormulaTrapezoideFragment()
                openFragment(fragment)
            }
            else -> false
        }
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}