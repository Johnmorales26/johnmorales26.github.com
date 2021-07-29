package com.example.supercalculadora.GeometryBodiesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivitySphereCapBinding
import com.example.supercalculadora.functionscalculator.Geometry3D
import java.text.DecimalFormat

class SphereCapActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySphereCapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySphereCapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val functions3D = Geometry3D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val radioA = binding.etRadioA.text.toString().toDouble()
                val Height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = functions3D.totalAreaSphereCap(radioA, Height)
                    tvResultPerimeter.text = two_Decimals(functions3D.lateralAreaSphereCap(radioA, Height).toDouble())
                    tvResultVolume.text = functions3D.volumeSphereCap(radioA, Height)
                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando side A
        if (binding.etRadioA.text.isNullOrEmpty()){
            binding.tilRadioA.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadioA.error = null
        }
        //  Evaluando side C
        if (binding.etHeight.text.isNullOrEmpty()){
            binding.tilHeight.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilHeight.error = null
        }
        return isValid
    }
    private fun two_Decimals(value: Double):String{
        val number = java.lang.Double.valueOf(value)
        val dec = DecimalFormat("#,###.00")
        val formating = dec.format(number)
        return formating
    }
}