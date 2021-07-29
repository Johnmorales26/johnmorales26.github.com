package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityCircularArcBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class CircularArcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCircularArcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCircularArcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val angleA = binding.etAngleA.text.toString().toDouble()
                val radius = binding.etRadius.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaCircularArc(angleA, radius)
                    tvResultPerimeter.text = triangleFunctions.perimeterCircularArc(angleA, radius)
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
        if (binding.etAngleA.text.isNullOrEmpty()){
            binding.tilAngleA.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilAngleA.error = null
        }
        //  Evaluando side B
        if (binding.etRadius.text.isNullOrEmpty()){
            binding.tilRadius.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadius.error = null
        }

        return isValid
    }
}