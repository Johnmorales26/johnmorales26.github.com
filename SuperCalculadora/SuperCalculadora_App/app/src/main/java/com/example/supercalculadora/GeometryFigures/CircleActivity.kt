package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityCircleBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class CircleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCircleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCircleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val sideA = binding.etRadius.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaCircle(sideA)
                    tvResultDiameter.text = triangleFunctions.diameterCircle(sideA)
                    tvResultCircunferencia.text = triangleFunctions.circunferenceCircle(sideA)
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
        return isValid
    }
}