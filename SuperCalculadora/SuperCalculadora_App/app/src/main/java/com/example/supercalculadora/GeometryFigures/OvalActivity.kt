package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityOvalBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class OvalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOvalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOvalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val radiusA = binding.etRadiusA.text.toString().toDouble()
                val radiusB = binding.etRadiusB.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaOval(radiusA, radiusB)
                    tvResultPerimeter.text = triangleFunctions.perimeterOval(radiusA, radiusB)
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
        if (binding.etRadiusA.text.isNullOrEmpty()){
            binding.tilRadiusA.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadiusA.error = null
        }
        //  Evaluando side B
        if (binding.etRadiusB.text.isNullOrEmpty()){
            binding.tilRadiusB.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadiusB.error = null
        }

        return isValid
    }
}