package com.johndev.smartcalculator.usecases.principalViews

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ActivityConversionBinding
import com.johndev.smartcalculator.usecases.common.Constantes
import com.johndev.smartcalculator.usecases.fragments.FragmentsBodies.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsConversion.ConversionAccelerationFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsConversion.ConversionAngleFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsConversion.ConversionAreaFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsConversion.ConversionDataStorageFragment
import com.johndev.smartcalculator.usecases.fragments.FragmentsFigures.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions.*
import com.johndev.smartcalculator.usecases.fragments.FragmentsOther.*
import com.johndev.smartcalculator.usecases.home.MainBodiesFragment
import com.johndev.smartcalculator.usecases.home.MainFiguresFragment
import com.squareup.picasso.Picasso

class ConversionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConversionBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        initAdds()
        configActionBar()
        configureTheme()
    }

    private fun configActionBar() {
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val idFunction = intent.getStringExtra(getString(R.string.key_function_id))?.toInt()
        val nameFunction = intent.getStringExtra(getString(R.string.key_function_name))
        supportActionBar?.title = nameFunction
        with(binding) {
            tvNameFunction.text = nameFunction
            if (idFunction != null) {
                Picasso.get().load(idFunction).into(imgPhoto)
            }
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
        finish()
    }

    private fun operationSelected(nameFunction: String?) {
        when (nameFunction) {
            getString(R.string.functions_content_angle) -> {
                addCounterForAdd()
                val fragment = ConversionAngleFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_acceleration) -> {
                addCounterForAdd()
                val fragment = ConversionAccelerationFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_data_storage) -> {
                addCounterForAdd()
                val fragment = ConversionDataStorageFragment()
                openFragment(fragment)
            }
            getString(R.string.functions_content_area) -> {
                addCounterForAdd()
                val fragment = ConversionAreaFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_time_time_difference) -> {
                addCounterForAdd()
                val fragment = OtherDifferenceTimeFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_time_add_time) -> {
                addCounterForAdd()
                val fragment = OtherAddTimeFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_date_date_difference) -> {
                addCounterForAdd()
                val fragment = OtherDifferenceDateFragment()
                openFragment(fragment)
            }
            getString(R.string.menu_date_date_add) -> {
                addCounterForAdd()
                val fragment = OtherAddDateFragment()
                openFragment(fragment)
            }
        }
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
            getString(R.string.preference_key_color_default) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryPurpleBackground))
                        cardView.strokeColor = getColor(R.color.primaryPurpleColor)
                    }
                }
            }
            getString(R.string.preference_key_color_red) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryRedColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryRedBackground))
                        cardView.strokeColor = getColor(R.color.primaryRedColor)
                    }
                }
            }
            getString(R.string.preference_key_color_yellow) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryYellowColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryYellowBackground))
                        cardView.strokeColor = getColor(R.color.primaryYellowColor)
                    }
                }
            }
            getString(R.string.preference_key_color_blue) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryBlueColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryBlueBackground))
                        cardView.strokeColor = getColor(R.color.primaryBlueColor)
                        //mainContainer.background.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(getColor(R.color.primaryBlueBackground), BlendModeCompat.SRC_ATOP)
                    }
                }
            }
            getString(R.string.preference_key_color_green) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryGreenColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryGreenBackground))
                        cardView.strokeColor = getColor(R.color.primaryGreenColor)
                    }
                }
            }
            getString(R.string.preference_key_color_purple) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryPurpleBackground))
                        cardView.strokeColor = getColor(R.color.primaryPurpleColor)
                    }
                }
            }
            getString(R.string.preference_key_color_orange) -> {
                with(binding) {
                    appBar.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryOrangeColor)))
                    if (MainActivity.sharedPreferences.getBoolean(getString(R.string.key_preference_enable_light_mode), true)) {
                        container.setBackgroundColor(getColor(R.color.primaryOrangeBackground))
                        cardView.strokeColor = getColor(R.color.primaryOrangeColor)
                    }
                }
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

    private fun showAdd(){
        MainActivity.interstitial?.show(this)
    }

}