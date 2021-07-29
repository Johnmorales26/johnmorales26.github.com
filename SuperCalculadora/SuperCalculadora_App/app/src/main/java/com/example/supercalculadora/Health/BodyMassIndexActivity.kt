package com.example.supercalculadora.Health

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.supercalculadora.databinding.ActivityBodyMassIndexBinding
import com.example.supercalculadora.databinding.ActivityDailyCaloriesBurnedBinding

class BodyMassIndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBodyMassIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBodyMassIndexBinding.inflate(layoutInflater)
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