package com.example.supercalculadora.Algebra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.databinding.ActivityCombinationsBinding
import com.example.supercalculadora.databinding.ActivityFractionsBinding

class CombinationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCombinationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombinationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}