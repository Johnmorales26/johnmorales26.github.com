package com.johndev.smartcalculator.usecases.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.johndev.smartcalculator.databinding.ActivityOperationsBinding
import com.johndev.smartcalculator.usecases.home.MainBodiesFragment
import com.johndev.smartcalculator.usecases.home.MainFiguresFragment

import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title_return)
            .setPositiveButton(R.string.btn_return) { dialogInterface, i -> finish() }
            .setNegativeButton(getString(R.string.btn_cancelar), null)
            .show()
    }

    private fun operationSelected(nameFunction: String?) {
        when (nameFunction) {
            // Algebra Screens
            getString(R.string.functions_content_percent) -> {
                val fragment = ContainerPercentFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_average) -> {
                val fragment = ContainerAverageFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_proportion) -> {
                val fragment = ContainerProportionFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_ecuations) -> {
                val fragment = ContainerEcuationsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_fractions) -> {
                val fragment = ContainerFractionsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_mcd_mcm) -> {
                val fragment = ContainerMCD_MCMFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_combinations) -> {
                val fragment = ContainerCombinationsFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_prime_numbers) -> {
                val fragment = ContainerPrimeNumbersFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_number_generator) -> {
                val fragment = ContainerNumberGeneratorFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_forms) -> {
                val fragment = MainFiguresFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_bodies) -> {
                val fragment = MainBodiesFragment()
                openFragment(fragment)
            }
            // Figures Screens
            getString(R.string.figures_content_triangle) -> {
                val fragment = FiguresTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_triangle_rectangle) -> {
                val fragment = FiguresRightTriangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_square) -> {
                val fragment = FiguresSquareFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_rectangle) -> {
                val fragment = FiguresRectangleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_trapezoid) -> {
                val fragment = FiguresTrapezoideFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_rhomb) -> {
                val fragment = FiguresRhombFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_pentagon) -> {
                val fragment = FiguresPentagonFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_hexagon) -> {
                val fragment = FiguresHexagonFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_circle) -> {
                val fragment = FiguresCircleFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_circular_arc) -> {
                val fragment = FiguresCircularArcFragment()
                openFragment(fragment)
            }
            getString(R.string.figures_content_oval) -> {
                val fragment = FiguresOvalFragment()
                openFragment(fragment)
            }
            // Geometric Bodies Screens
            getString(R.string.bodies_content_cube) -> {
                val fragment = BodiesCubeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_prism) -> {
                val fragment = BodiesRectangularPrismFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_pyramid) -> {
                val fragment = BodiesPyramidFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cut_pyramid) -> {
                val fragment = BodiesCutPyramidFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cone) -> {
                val fragment = BodiesConeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cone_cut) -> {
                val fragment = BodiesCutConeFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_cylinder) -> {
                val fragment = BodiesCylinderFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere) -> {
                val fragment = BodiesSphereFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere_cap) -> {
                val fragment = BodiesSphereCapFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_sphere_segment) -> {
                val fragment = BodiesSphereSegmentFragment()
                openFragment(fragment)
            }
            getString(R.string.bodies_content_ellipsoid) -> {
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
}