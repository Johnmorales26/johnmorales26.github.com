package com.example.supercalculadora.GeometryBodiesActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivitySphereBinding
import com.example.supercalculadora.functionscalculator.Geometry3D

class SphereActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySphereBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySphereBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val functions3D = Geometry3D()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val radio = binding.etRadio.text.toString().toDouble()
                with(binding){
                    tvResultArea.text = functions3D.totalAreaSfere(radio)
                    tvResultVolume.text = functions3D.volumeSfere(radio)
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
        if (binding.etRadio.text.isNullOrEmpty()){
            binding.tilRadio.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadio.error = null
        }
        return isValid
    }
}