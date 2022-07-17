package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContainerNumberGeneratorBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra
import android.widget.Toast




class ContainerNumberGeneratorFragment : Fragment() {

    private var _binding: FragmentContainerNumberGeneratorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContainerNumberGeneratorBinding.inflate(inflater, container, false)

        //*************************************************************************
        val algebra = FunctionsAlgebra(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val valueA = binding.etVariableA.text.toString().toInt()
                val valueB = binding.etVariableB.text.toString().toInt()
                val valueC = binding.etVariableC.text.toString().toInt()
                if (validOrder(valueA, valueB)){
                    with(binding){
                        tvResult.text = algebra.random(valueA, valueB, valueC)
                    }
                }
            }
        }
        //*************************************************************************

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvUnique.setOnClickListener {
            when(binding.tvUnique.text) {
                "Si", "Yes" -> binding.tvUnique.text = getString(R.string.hint_value_no)
                "No" -> binding.tvUnique.text = getString(R.string.hint_value_yes)
            }
        }
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
        //  Evaluando value C
        if (binding.etVariableC.text.isNullOrEmpty()){
            binding.tilVariableC.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilVariableC.error = null
        }
        return isValid
    }

    private fun validOrder(valueA: Int, valueB: Int):Boolean{
        return if (valueA < valueB){
            true
        } else {
            viewMessage(getString(R.string.alert_wrong_value))
            false
        }
    }

    private fun viewMessage(text: String){
        val toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        toast.show()
    }

}