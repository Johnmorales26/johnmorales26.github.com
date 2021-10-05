package com.example.mdspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mdspinner.databinding.ActivityMainBinding
import java.util.*
import java.util.Arrays.asList

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var aaCountries: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        aaCountries = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item)

        aaCountries.addAll(Arrays.asList("Mexico", "España", "Peru", "Chile"))
        aaCountries.add("Argentina")

        binding.spinnerCountries.onItemSelectedListener = this
        binding.spinnerCountries.adapter = aaCountries
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var countrieSelected = aaCountries.getItem(p2)
        binding.tvSelected.text = countrieSelected
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}