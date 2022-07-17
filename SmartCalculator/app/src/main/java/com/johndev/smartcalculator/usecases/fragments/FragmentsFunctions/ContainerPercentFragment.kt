package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContainerPercentBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment

class ContainerPercentFragment : Fragment() {

    private var _binding: FragmentContainerPercentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerPercentBinding.inflate(inflater, container, false)

        binding.btnMenuCalculate.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnMenuCalculate.text = data.name.trim()
                    binding.tvFormula.text = data.icon.trim()
                    manageItemClick(data.name.trim())
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.functions_content_percent))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }

        binding.btnResult.setOnClickListener {
            if (validFields()) {
                val operation = binding.btnMenuCalculate.text.toString()
                val valueA = binding.etVariableA.text.toString().toDouble()
                val valueB = binding.etVariableB.text.toString().toDouble()
                selectorOperation(valueA, valueB, operation)
            }
        }
        return binding.root
    }

    private fun manageItemClick(option: String): Boolean {
        return when(option){
            getString(R.string.menu_options_descuento) -> {
                binding.tvFormula.text = getString(R.string.formula_options_descuento)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_descuento)
                visibilityResult(1)
                true
            }
            getString(R.string.menu_options_increment) -> {
                binding.tvFormula.text = getString(R.string.formula_options_increment)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_increment)
                visibilityResult(2)
                true
            }
            getString(R.string.menu_options_simple_porcent) -> {
                binding.tvFormula.text = getString(R.string.formula_options_simple_porcent)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_simple_porcent)
                visibilityResult(3)
                true
            }
            getString(R.string.menu_options_increment_decrement) -> {
                binding.tvFormula.text = getString(R.string.formula_options_increment_decrement)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_increment_decrement)
                visibilityResult(4)
                true
            }
            getString(R.string.menu_options_porcent_from_a_to_b) -> {
                binding.tvFormula.text = getString(R.string.formula_options_porcent_from_a_to_b)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_porcent_from_a_to_b)
                visibilityResult(5)
                true
            }
            else -> false
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

    private fun visibilityResult(option: Int) {
        when(option) {
            1, 2 -> {
                binding.cvViewTwo.visibility = GONE
                binding.cvViewOneLeft.visibility = VISIBLE
                binding.cvViewOneRight.visibility = VISIBLE
            }
            3, 4, 5 -> {
                binding.cvViewOneLeft.visibility = GONE
                binding.cvViewOneRight.visibility = GONE
                binding.cvViewTwo.visibility = VISIBLE
            }
        }
    }

    private fun selectorOperation(valueA: Double, valueB: Double, operation: String) {
        val algebra = FunctionsAlgebra(requireContext())
        when (operation) {
            getString(R.string.menu_options_descuento) -> {
                with(binding) {
                    tvResult.text = algebra.discountTotal(valueA, valueB)
                    tvPercent.text = algebra.discountPercent(valueA, valueB)
                }
            }
            getString(R.string.menu_options_increment) -> {
                with(binding) {
                    tvResult.text = algebra.incrementTotal(valueA, valueB)
                    tvPercent.text = algebra.percentIncrement(valueA, valueB)
                }
            }
            getString(R.string.menu_options_simple_porcent) -> {
                with(binding) {
                    tvResultadoViewTwo.text = algebra.simplePercent(valueA, valueB)
                }
            }
            getString(R.string.menu_options_increment_decrement) -> {
                with(binding) {
                    tvResultadoViewTwo.text =
                        algebra.incrementAndDecrement(valueA, valueB)
                }
            }
            getString(R.string.menu_options_porcent_from_a_to_b) -> {
                with(binding) {
                    tvResultadoViewTwo.text = algebra.percentOfAsinceB(valueA, valueB)
                }
            }
        }
    }

    private fun showMessage(title: CharSequence) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
    }

}