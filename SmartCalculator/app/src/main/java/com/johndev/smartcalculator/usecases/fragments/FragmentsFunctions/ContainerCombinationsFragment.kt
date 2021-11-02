package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContainerCombinationsBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra

class ContainerCombinationsFragment : Fragment() {

    private var _binding: FragmentContainerCombinationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContainerCombinationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOptionOrdered.setOnClickListener {
            when(binding.tvOptionOrdered.text) {
                "Yes", "Si" -> binding.tvOptionOrdered.text = getString(R.string.hint_value_no)
                "No" -> binding.tvOptionOrdered.text = getString(R.string.hint_value_yes)
            }
        }
        binding.tvOptionRepeatable.setOnClickListener {
            when(binding.tvOptionRepeatable.text) {
                "Yes", "Si" -> binding.tvOptionRepeatable.text = getString(R.string.hint_value_no)
                "No" -> binding.tvOptionRepeatable.text = getString(R.string.hint_value_yes)
            }
        }

        val algebra = FunctionsAlgebra()
        binding.btnResult.setOnClickListener {
            val optionOrg = binding.tvOptionOrdered.text
            val optionRep = binding.tvOptionRepeatable.text
            if (validFields()) {
                val valueA = binding.etVariableA.text.toString().toInt()
                var cValueA = valueA.toDouble()
                val valueB = binding.etVariableB.text.toString().toInt()
                //combinationWithOrganizedAndRepeated
                if (optionOrg == "Si" && optionRep == "Si"){
                    binding.tvResPermutations.text = algebra.combinationWithOrganizedAndRepeated(cValueA, valueB)
                }else if (optionOrg == "No" && optionRep == "Si"){
                    //combinationWithRepeated
                    binding.tvResPermutations.text = algebra.combinationWithRepeated(cValueA, valueB)
                }else if (optionOrg == "Si" && optionRep == "No"){
                    //combinationWithOrganized
                    binding.tvResPermutations.text = algebra.combinationWithOrganized(cValueA, valueB)
                }else{
                    //combination
                    binding.tvResPermutations.text = algebra.combination(cValueA, valueB)
                }
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
        return isValid
    }

}