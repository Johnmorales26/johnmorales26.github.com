package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityPentagonBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class PentagonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPentagonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPentagonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = triangleFunctions.areaPentagon(sideA)
                    tvResultPerimeter.text = triangleFunctions.perimeterPentagon(sideA)
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
        return isValid
    }
}