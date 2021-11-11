package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasForms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasShiftTriangleBinding

class FormulasShiftTriangleFragment : Fragment() {

    private var _binding: FragmentFormulasShiftTriangleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasShiftTriangleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ A = \\frac{1}{2} ab + \\frac{1}{2} ch $$"
        val formulaOtherOne = "$$ a^2 + b^2 = c^2 $$"
        val formulaOtherTwo = "$$\\frac{1}{h^2} = \\frac{1}{a^2} +  \\frac{1}{b^2} $$"
        binding.formulaArea.text = formulaArea
        binding.otherFormulas.text = formulaOtherOne
        binding.otherFormulasTwo.text = formulaOtherTwo
    }

}