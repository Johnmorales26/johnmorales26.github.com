package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityTrapezoidBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class TrapezoidActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTrapezoidBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrapezoidBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaTrapezoid(sideA, sideB, height)
                    tvResultPerimeter.text = triangleFunctions.perimeterTrapezoid(sideA, sideB, height)
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
        if (binding.etSideA.text.isNullOrEmpty()){
            binding.tilSideA.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideA.error = null
        }
        //  Evaluando side B
        if (binding.etSideB.text.isNullOrEmpty()){
            binding.tilSideB.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideB.error = null
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
}