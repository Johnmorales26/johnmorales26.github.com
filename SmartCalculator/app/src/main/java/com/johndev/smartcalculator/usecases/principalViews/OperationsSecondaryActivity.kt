package com.johndev.smartcalculator.usecases.principalViews

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityOperationsSecondaryBinding
import com.johndev.smartcalculator.usecases.common.Constantes
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.EcuationLinealFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.EcuationQuadraticFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.FractionSimplifierFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.FractionToDecimalFragment
import com.squareup.picasso.Picasso

class OperationsSecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperationsSecondaryBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperationsSecondaryBinding.inflate(layoutInflater)
        initAdds()
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val idFunction = intent.getStringExtra(getString(R.string.key_function_id))?.toInt()
        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))
        with(binding) {
            toolbar.title = nameFunction
            tvNameFunction.text = nameFunction
            if (idFunction != null) Picasso.get().load(idFunction).into(imgPhoto)
        }
        configureTheme()
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
        /*MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title_return)
            .setPositiveButton(R.string.btn_return) { dialogInterface, i -> finish() }
            .setNegativeButton(getString(R.string.btn_cancelar), null)
            .show()*/
        finish()
    }

    private fun operationSelected(nameFunction: String?) {
        when (nameFunction) {
            getString(R.string.menu_options_lineal_ecuations) -> {
                addCounterForAdd()
                val fragment = EcuationLinealFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_quadratics_ecuations) -> {
                addCounterForAdd()
                val fragment = EcuationQuadraticFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_fraction_simplifier) -> {
                addCounterForAdd()
                val fragment = FractionSimplifierFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_options_decimal_to_fraction) -> {
                addCounterForAdd()
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

    fun addCounterForAdd(){
        MainActivity.counterAdds += 1
        checkCounter()
    }

    fun initAdds(){
        var adRequest: AdRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, Constantes.ADD_UNITS, adRequest,
            object: InterstitialAdLoadCallback(){
                override fun onAdLoaded(p0: InterstitialAd) {
                    MainActivity.interstitial = p0
                }
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    MainActivity.interstitial = null
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
        MainActivity.interstitial?.show(this)
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