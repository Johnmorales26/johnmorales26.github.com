package com.example.supercalculadora.GeometryBodiesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.databinding.ActivityConeBinding
import com.example.supercalculadora.R
import com.example.supercalculadora.functionscalculator.Geometry3D
import java.text.DecimalFormat

class ConeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val functions3D = Geometry3D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val radius = binding.etRadius.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = two_Decimals(functions3D.totalAreaCone(radius, height).toDouble())
                    tvResultPerimeter.text = two_Decimals(functions3D.lateralAreaCone(radius, height).toDouble())
                    tvResultVolume.text = two_Decimals(functions3D.volumeCone(radius, height).toDouble())
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
        if (binding.etRadius.text.isNullOrEmpty()){
            binding.tilRadius.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadius.error = null
        }
        //  Evaluando side B
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