package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityTriangleRectangleBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class TriangleRectangleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTriangleRectangleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriangleRectangleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaTR(sideA, sideB)
                    tvResultPerimeter.text = triangleFunctions.perimeterTR(sideA, sideB)
                    tvResultHypotenuse.text = triangleFunctions.hypotenuseTR(sideA, sideB)
                    tvResultAngleA.text = angleFormat(triangleFunctions.angleA_TR(sideA, sideB))
                    tvResultAngleB.text = angleFormat(triangleFunctions.angleB_TR(sideA, sideB))
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

        return isValid
    }
    private fun angleFormat(text: String):String{
        return "${text}°"
    }
}