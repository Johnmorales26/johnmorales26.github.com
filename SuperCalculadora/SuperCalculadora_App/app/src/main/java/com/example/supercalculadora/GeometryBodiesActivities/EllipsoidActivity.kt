package com.example.supercalculadora.GeometryBodiesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityEllipsoidBinding
import com.example.supercalculadora.functionscalculator.Geometry3D

class EllipsoidActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEllipsoidBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEllipsoidBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val functions3D = Geometry3D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val radioA = binding.etRadioA.text.toString().toDouble()
                val radioB = binding.etRadioB.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = functions3D.totalAreaEllipsoid(radioA, radioB, height)
                    tvResultVolume.text = functions3D.volumeEllipsoid(radioA, radioB, height)
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
        //  Evaluando side A
        if (binding.etRadioB.text.isNullOrEmpty()){
            binding.tilRadioB.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadioB.error = null
        }
        //  Evaluando side A
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