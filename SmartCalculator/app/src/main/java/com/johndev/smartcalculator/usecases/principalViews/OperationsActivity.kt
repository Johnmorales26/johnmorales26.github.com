package com.johndev.smartcalculator.usecases.principalViews

import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.databinding.ActivityOperationsBinding
import com.johndev.smartcalculator.usecases.home.MainBodiesFragment
import com.johndev.smartcalculator.usecases.home.MainFiguresFragment

import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.MainActivity.Companion.interstitial
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.usecases.common.Constantes
import com.johndev.smartcalculator.usecases.fragments.FragmentsBodies.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsConversion.ConversionAngleFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFigures.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.OtherAgeFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.OtherBodyMassFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.OtherFibonacciFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.OtherLawOhmFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.SecondaryMenus.MenuDateFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.SecondaryMenus.MenuTimeFragment
import com.squareup.picasso.Picasso

class OperationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperationsBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsBinding.inflate(layoutInflater)
        initAdds()
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idFunction = intent.getStringExtra(getString(R.string.key_function_id))?.toInt()
        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))

        supportActionBar?.title = nameFunction

        with(binding) {
            toolbar.title = nameFunction
            tvNameFunction.text = nameFunction
            if (idFunction != null) {
                Picasso.get().load(idFunction).into(imgPhoto)
            }
        }
        configureTheme()
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
            getString(R.string.functions_content_body_mass) -> {
                addCounterForAdd()
                val fragment = OtherBodyMassFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_ohm) -> {
                addCounterForAdd()
                val fragment = OtherLawOhmFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_age) -> {
                addCounterForAdd()
                val fragment = OtherAgeFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_angle) -> {
                addCounterForAdd()
                val fragment = ConversionAngleFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_date) -> {
                addCounterForAdd()
                val fragment = MenuDateFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_time) -> {
                addCounterForAdd()
                val fragment = MenuTimeFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_fibonacci) -> {
                addCounterForAdd()
                val fragment = OtherFibonacciFragment()
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

    private fun addCounterForAdd(){
        MainActivity.counterAdds += 1
        checkCounter()
    }

    private fun initAdds(){
        var adRequest: AdRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, Constantes.ADD_UNITS, adRequest,
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

    private fun showAdd(){
        interstitial?.show(this)
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
            getString(R.string.preference_key_color_default) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryPurpleBackground))
                    }
                }
            }
            getString(R.string.preference_key_color_red) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryRedColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryRedBackground))
                    }
                }
            }
            getString(R.string.preference_key_color_yellow) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryYellowColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryYellowBackground))
                    }
                }
            }
            getString(R.string.preference_key_color_blue) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryBlueColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryBlueBackground))
                        //mainparentView.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(getColor(R.color.primaryBlueBackground), BlendModeCompat.SRC_ATOP)
                    }
                }
            }
            getString(R.string.preference_key_color_green) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryGreenColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryGreenBackground))
                    }
                }
            }
            getString(R.string.preference_key_color_purple) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryPurpleBackground))
                    }
                }
            }
            getString(R.string.preference_key_color_orange) -> {
                with(binding) {
                    toolbar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryOrangeColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        parentView.setBackgroundColor(getColor(R.color.primaryOrangeBackground))
                    }
                }
            }
        }
    }

}