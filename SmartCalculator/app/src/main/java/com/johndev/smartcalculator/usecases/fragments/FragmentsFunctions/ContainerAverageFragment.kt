package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContanierAverageBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra
import com.johndev.smartcalculator.usecases.common.ViewDecimals


class ContainerAverageFragment : Fragment() {

    private var _binding: FragmentContanierAverageBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentContanierAverageBinding.inflate(inflater, container, false)

        val algebra = FunctionsAlgebra(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val valueA = binding.etVariableA.text.toString().toDouble()
                val valueB = binding.etVariableB.text.toString().toDouble()
                with(binding){
                    val VD = ViewDecimals(requireContext())
                    tvArithmeticResult.text = VD.selectedDecimals(algebra.arithmetic(valueA, valueB))
                    tvGeometricResult.text = VD.selectedDecimals(algebra.geometric(valueA, valueB))
                    tvHarmonicResult.text = VD.selectedDecimals(algebra.harmonic(valueB, valueB))
                }
            }
        }

        return binding.root
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etVariableA.text.isNullOrEmpty()){
            binding.tilVariableA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilVariableA.error = null
        }
        //  Evaluando value B
        if (binding.etVariableB.text.isNullOrEmpty()){
            binding.tilVariableB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilVariableB.error = null
        }
        return isValid
    }
}