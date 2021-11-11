package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasFractionBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasPolinomiosBinding

class FormulasFractionFragment : Fragment() {

    private var _binding: FragmentFormulasFractionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasFractionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaOne = "$$ \\frac{a}{b} \\pm \\frac{c}{d} = \\frac{ad \\pm cb}{db} $$"
        val formulaTwo = "$$ \\frac{a}{b} \\times \\frac{c}{d} = \\frac{ac}{bd} $$"
        val formulaThree = "$$ \\frac{a}{b} : \\frac{c}{d} = \\frac{ad}{bc} $$"
        val formulaFour = "$$ a \\frac{b}{c} = \\frac{ac + b}{c} $$"
        binding.formulaOne.text = formulaOne
        binding.formulaTwo.text = formulaTwo
        binding.formulaThree.text = formulaThree
        binding.formulaFour.text = formulaFour
    }

}