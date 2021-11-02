package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContainerProportionBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra

class ContainerProportionFragment : Fragment() {

    private var _binding: FragmentContainerProportionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentContainerProportionBinding.inflate(inflater, container, false)

        binding.btnMenuCalculate.setOnClickListener { view1 ->
            val popupMenu = activity?.let { PopupMenu(it, view1) }
            popupMenu?.menuInflater?.inflate(R.menu.menu_options_proportion, popupMenu.menu)
            popupMenu?.setOnMenuItemClickListener (::manageItemClick)
            popupMenu?.setOnDismissListener(::manageDismiss)
            popupMenu?.show()
        }

        val algebra = FunctionsAlgebra()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val valueA = binding.etVariableA.text.toString().toDouble()
                val valueB = binding.etVariableB.text.toString().toDouble()
                val valueX = binding.etVariableX.text.toString().toDouble()
                if (binding.btnMenuCalculate.text == getString(R.string.menu_options_directly_proportional)){
                        binding.tvResultado.text = algebra.directlyProportional(valueA, valueB, valueX)
                }else{
                    binding.tvResultado.text = algebra.indirectlyProportional(valueA, valueB, valueX)
                }
            }
        }

        return binding.root
    }

    private fun manageDismiss(popupMenu: PopupMenu) {
        showMessage("Menú cerrado")
    }

    private fun manageItemClick(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.action_directly_proportional -> {
                binding.tvFormula.text = getString(R.string.formula_options_directly_proportional)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_directly_proportional)
                true
            }
            R.id.action_indirectly_proportional -> {
                binding.tvFormula.text = getString(R.string.formula_options_indirectly_proportionalb)
                binding.btnMenuCalculate.text = getString(R.string.menu_options_indirectly_proportional)
                true
            }
            else -> false
        }
    }

    private fun showMessage(title: CharSequence) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
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
        //  Evaluando value Bx
        if (binding.etVariableX.text.isNullOrEmpty()){
            binding.tilVariableX.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilVariableX.error = null
        }
        return isValid
    }

}