package com.example.supercalculadora.Algebra.PercentOptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.supercalculadora.R
import com.example.supercalculadora.databinding.ActivityIncreaseDecreaseBinding
import com.example.supercalculadora.functionscalculator.Algebra

class IncreaseDecreaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIncreaseDecreaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncreaseDecreaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val algebra = Algebra()
        binding.btnCalculate.setOnClickListener{
            if (validFields()){
                val valueA = binding.etValueA.text.toString().toDouble()
                val valueB = binding.etValueB.text.toString().toDouble()
                with(binding){
                    tvValueResult.text = algebra.incrementAndDecrement(valueA, valueB)
                    btnViewOperation.visibility = View.VISIBLE
                    btnClear.visibility = View.VISIBLE
                }
                binding.btnViewOperation.setOnClickListener {
                    binding.cvOperations.visibility = View.VISIBLE
                    binding.tvOperations.text = algebra.incrementAndDecrementOperation(valueA, valueB)
                }
                binding.btnClear.setOnClickListener {
                    binding.cvOperations.visibility = View.INVISIBLE
                    binding.btnClear.visibility = View.INVISIBLE
                    binding.btnViewOperation.visibility = View.INVISIBLE
                    binding.cvOperations.visibility = View.INVISIBLE
                    binding.tvValueResult.text = "-"
                    binding.tvOperations.text = ""
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
        //  Evaluando value A
        if (binding.etValueA.text.isNullOrEmpty()){
            binding.tilValueA.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilValueA.error = null
        }
        //  Evaluando value B
        if (binding.etValueB.text.isNullOrEmpty()){
            binding.tilValueB.run {
                error = getString(R.string.help_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilValueB.error = null
        }
        return isValid
    }
}