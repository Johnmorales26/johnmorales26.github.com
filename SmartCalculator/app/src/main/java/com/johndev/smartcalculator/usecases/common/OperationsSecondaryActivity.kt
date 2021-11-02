package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityOperationsSecondaryBinding
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.EcuationLinealFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.EcuationQuadraticFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.FractionSimplifierFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.FractionToDecimalFragment
import com.squareup.picasso.Picasso

class OperationsSecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperationsSecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsSecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idFunction = intent.getStringExtra(getString(R.string.key_function_id))?.toInt()
        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))
        with(binding) {
            toolbar.title = nameFunction
            tvNameFunction.text = nameFunction
            if (idFunction != null) Picasso.get().load(idFunction).into(imgPhoto)
        }
        operationSelected(nameFunction)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
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
            getString(R.string.menu_options_lineal_ecuations) -> {
                val fragment = EcuationLinealFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_quadratics_ecuations) -> {
                val fragment = EcuationQuadraticFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_fraction_simplifier) -> {
                val fragment = FractionSimplifierFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_decimal_to_fraction) -> {
                val fragment = FractionToDecimalFragment()
                openFragment(fragment)
            }
        }
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}