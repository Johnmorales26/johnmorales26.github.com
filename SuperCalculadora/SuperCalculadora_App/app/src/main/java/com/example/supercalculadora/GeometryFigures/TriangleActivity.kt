package com.example.supercalculadora.GeometryFigures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityTriangleBinding
import com.example.supercalculadora.functionscalculator.Geometry2D

class TriangleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTriangleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriangleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val triangleFunctions = Geometry2D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val sideC = binding.etSideC.text.toString().toDouble()
                triangleFunctions.areaTriangleEquilateral(sideA, sideB, sideC)
                with(binding){
                    tvResultArea.text = triangleFunctions.areaTriangleEquilateral(sideA, sideB, sideC)
                    tvResultPerimeter.text = triangleFunctions.perimeterTriangleEquilateral(sideA)
                    tvResultAngleAB.text = angleFormat(triangleFunctions.angleAB(sideA, sideB, sideC))
                    tvResultAngleBC.text = angleFormat(triangleFunctions.angleBC(sideA, sideB, sideC))
                    tvResultAngleAC.text = angleFormat(triangleFunctions.angleAC(sideA, sideB, sideC))
                    tvResultHeightA.text = triangleFunctions.heightA(sideA, sideB, sideC)
                    tvResultHeightB.text = triangleFunctions.heightC(sideA, sideB, sideC)
                    tvResultHeightC.text = triangleFunctions.heightB(sideA, sideB, sideC)
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
        if (binding.etSideC.text.isNullOrEmpty()){
            binding.tilSideC.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideC.error = null
        }

        return isValid
    }
    private fun angleFormat(text: String):String{
        return "${text}°"
    }
}