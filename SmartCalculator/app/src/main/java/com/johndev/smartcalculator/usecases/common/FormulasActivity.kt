package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.MainActivity.Companion.interstitial
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityFormulasBinding
import com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasForms.*

class FormulasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormulasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormulasBinding.inflate(layoutInflater)
        initAdds()
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
        /*MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title_return)
            .setPositiveButton(R.string.btn_return) { dialogInterface, i -> finish() }
            .setNegativeButton(getString(R.string.btn_cancelar), null)
            .show()*/
        finish()
    }

    private fun operationSelected(nameFunction: String?) {
        when (nameFunction) {
            //  Forms
            getString(R.string.formula_triangle) -> {
                addCounterForAdd()
                val fragment = FormulaTriangleFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_right_triangle) -> {
                addCounterForAdd()
                val fragment = FormulasShiftTriangleFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_square) -> {
                addCounterForAdd()
                val fragment = FormulaSquareFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_rectangle) -> {
                addCounterForAdd()
                val fragment = FormulaRectangleFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_parallelogram) -> {
                addCounterForAdd()
                val fragment = FormulaParalelogramoFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_rhomb) -> {
                addCounterForAdd()
                val fragment = FormulaRhombFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_trapezoid) -> {
                addCounterForAdd()
                val fragment = FormulaTrapezoideFragment()
                openFragment(fragment)
            }
            //  Bodies
            getString(R.string.formula_sphere) -> {
                addCounterForAdd()
                val fragment = FormulasSpehreFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_spherical_cap) -> {
                addCounterForAdd()
                val fragment = FormulaSphericalCapFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_spherical_segment) -> {
                addCounterForAdd()
                val fragment = FormulaSphericalSegmentFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_spherical_sector) -> {
                addCounterForAdd()
                val fragment = FormulaSphericalSectorFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_torus) -> {
                addCounterForAdd()
                val fragment = FormulaTorusFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_cylinder) -> {
                addCounterForAdd()
                val fragment = FormulaCylinderFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_cone) -> {
                addCounterForAdd()
                val fragment = FormulaConeFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_cone_trunk) -> {
                addCounterForAdd()
                val fragment = FormulasConeTrunkFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_pyramid) -> {
                addCounterForAdd()
                val fragment = FormulaPyramidFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_prism) -> {
                addCounterForAdd()
                val fragment = FormulaCuboideFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_triangular_prism) -> {
                addCounterForAdd()
                val fragment = FormulaTriangularPrismFragment()
                openFragment(fragment)
            }
            //  Algebra
            getString(R.string.formula_polynomials) -> {
                addCounterForAdd()
                val fragment = FormulasPolinomiosFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_fraction) -> {
                addCounterForAdd()
                val fragment = FormulasFractionFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_identity) -> {
                addCounterForAdd()
                val fragment = FormulasIdentidadFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_empowerment) -> {
                addCounterForAdd()
                val fragment = FormulasPotenciacionFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_settlement) -> {
                addCounterForAdd()
                val fragment = FormulasRadicacionFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_the_summations) -> {
                addCounterForAdd()
                val fragment = FormulasSumatoriasFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_decimal_logarithm) -> {
                addCounterForAdd()
                val fragment = FormulasLogaritmoDecimalFragment()
                openFragment(fragment)
            }

            getString(R.string.formula_natural_logarithm) -> {
                addCounterForAdd()
                val fragment = FormulaLogaritmoNaturalFragment()
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

    fun addCounterForAdd(){
        MainActivity.counterAdds += 1
        checkCounter()
    }

    fun initAdds(){
        var adRequest: AdRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object: InterstitialAdLoadCallback(){
                override fun onAdLoaded(p0: InterstitialAd) {
                    interstitial = p0
                }
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitial = null
                }
            })
    }

    private fun checkCounter() {
        if (MainActivity.counterAdds == 5){
            showAdd()
            MainActivity.counterAdds = 0
        }
    }

    fun showAdd(){
        interstitial?.show(this)
    }

}