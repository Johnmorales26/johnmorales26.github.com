package com.example.supercalculadora.Algebra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityFractionsBinding
import com.example.supercalculadora.databinding.ActivityNumberGeneratorBinding
import com.example.supercalculadora.functionscalculator.Algebra
import com.example.supercalculadora.functionscalculator.Geometry2D

class NumberGeneratorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNumberGeneratorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberGeneratorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val algebra = Algebra()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val from = binding.etFrom.text.toString().toInt()
                val until = binding.etUntil.text.toString().toInt()
                val count = binding.etCount.text.toString().toInt()
                with(binding){
                    tvResult.text = algebra.random(from, until, count)
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
        //  Evaluando From
        if (binding.etFrom.text.isNullOrEmpty()){
            binding.tilFrom.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilFrom.error = null
        }
        //  Evaluando Until
        if (binding.etUntil.text.isNullOrEmpty()){
            binding.tilUntil.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilUntil.error = null
        }
        //  Evaluando side C
        if (binding.etCount.text.isNullOrEmpty()){
            binding.tilCount.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilCount.error = null
        }
        return isValid
    }
}