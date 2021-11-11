package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.johndev.smartcalculator.databinding.ActivityOperationsBinding
import com.johndev.smartcalculator.usecases.home.MainBodiesFragment
import com.johndev.smartcalculator.usecases.home.MainFiguresFragment

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.MainActivity.Companion.interstitial
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.usecases.fragments.FragmentsBodies.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFigures.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.*
import com.squareup.picasso.Picasso

class OperationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsBinding.inflate(layoutInflater)
        initAdds()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idFunction = intent.getStringExtra(getString(R.string.key_function_id))?.toInt()
        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))
        with(binding) {
            toolbar.title = nameFunction
            tvNameFunction.text = nameFunction
            if (idFunction != null) {
                Picasso.get().load(idFunction).into(imgPhoto)
            }
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
            // Algebra Screens
            getString(R.string.functions_content_percent) -> {
                addCounterForAdd()
                val fragment = ContainerPercentFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_average) -> {
                addCounterForAdd()
                val fragment = ContainerAverageFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_proportion) -> {
                addCounterForAdd()
                val fragment = ContainerProportionFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_ecuations) -> {
                addCounterForAdd()
                val fragment = ContainerEcuationsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_fractions) -> {
                addCounterForAdd()
                val fragment = ContainerFractionsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_mcd_mcm) -> {
                addCounterForAdd()
                val fragment = ContainerMCD_MCMFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_combinations) -> {
                addCounterForAdd()
                val fragment = ContainerCombinationsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_prime_numbers) -> {
                addCounterForAdd()
                val fragment = ContainerPrimeNumbersFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_number_generator) -> {
                addCounterForAdd()
                val fragment = ContainerNumberGeneratorFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_forms) -> {
                addCounterForAdd()
                val fragment = MainFiguresFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_bodies) -> {
                addCounterForAdd()
                val fragment = MainBodiesFragment()
                openFragment(fragment)
            }
            // Figures Screens
            getString(R.string.figures_content_triangle) -> {
                addCounterForAdd()
                val fragment = FiguresTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_triangle_rectangle) -> {
                addCounterForAdd()
                val fragment = FiguresRightTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_square) -> {
                addCounterForAdd()
                val fragment = FiguresSquareFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_rectangle) -> {
                addCounterForAdd()
                val fragment = FiguresRectangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_trapezoid) -> {
                addCounterForAdd()
                val fragment = FiguresTrapezoideFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_rhomb) -> {
                addCounterForAdd()
                val fragment = FiguresRhombFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_pentagon) -> {
                addCounterForAdd()
                val fragment = FiguresPentagonFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_hexagon) -> {
                addCounterForAdd()
                val fragment = FiguresHexagonFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_circle) -> {
                addCounterForAdd()
                val fragment = FiguresCircleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_circular_arc) -> {
                addCounterForAdd()
                val fragment = FiguresCircularArcFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_oval) -> {
                addCounterForAdd()
                val fragment = FiguresOvalFragment()
                openFragment(fragment)
            }
            // Geometric Bodies Screens
            getString(R.string.bodies_content_cube) -> {
                addCounterForAdd()
                val fragment = BodiesCubeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_prism) -> {
                addCounterForAdd()
                val fragment = BodiesRectangularPrismFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_pyramid) -> {
                addCounterForAdd()
                val fragment = BodiesPyramidFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cut_pyramid) -> {
                addCounterForAdd()
                val fragment = BodiesCutPyramidFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cone) -> {
                addCounterForAdd()
                val fragment = BodiesConeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cone_cut) -> {
                addCounterForAdd()
                val fragment = BodiesCutConeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cylinder) -> {
                addCounterForAdd()
                val fragment = BodiesCylinderFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere) -> {
                addCounterForAdd()
                val fragment = BodiesSphereFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere_cap) -> {
                addCounterForAdd()
                val fragment = BodiesSphereCapFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere_segment) -> {
                addCounterForAdd()
                val fragment = BodiesSphereSegmentFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_ellipsoid) -> {
                addCounterForAdd()
                val fragment = BodiesEllipsoidFragment()
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