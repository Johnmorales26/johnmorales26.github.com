package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentEcuationQuadraticBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra

class EcuationQuadraticFragment : Fragment() {

    private var _binding: FragmentEcuationQuadraticBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEcuationQuadraticBinding.inflate(inflater, container, false)

        //*************************************************************************
        val algebra = FunctionsAlgebra()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val valueA = binding.etVariableA.text.toString().toDouble()
                val valueB = binding.etVariableB.text.toString().toDouble()
                val valueC = binding.etVariableC.text.toString().toDouble()
                with(binding){
                    tvX1.text = algebra.quadraticEquationPositive(valueA, valueB, valueC)
                    tvX2.text = algebra.quadraticEquationNegative(valueA, valueB, valueC)
                }
            }
        }
        //*************************************************************************

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