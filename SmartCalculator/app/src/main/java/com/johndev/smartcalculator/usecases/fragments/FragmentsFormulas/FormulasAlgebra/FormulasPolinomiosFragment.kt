package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaTriangularPrismBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasPolinomiosBinding

class FormulasPolinomiosFragment : Fragment() {

    private var _binding: FragmentFormulasPolinomiosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasPolinomiosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaOne = "$$ (a + b + c)x = ax + bx + cx $$"
        val formulaTwo = "$$ (a + b)(m + n) = a(m + n) + b(m + n) $$"
        val formulaTwoPartTwo = "$$ = am + an + bm + bn $$"
        val formulaThree = "$$ \\frac{a + b + c}{c} = \\frac{a}{x} + \\frac{b}{x} + \\frac{c}{x} $$"
        binding.formulaOne.text = formulaOne
        binding.formulaTwo.text = formulaTwo
        binding.formulaTwoPart2.text = formulaTwoPartTwo
        binding.formulaThree.text = formulaThree
    }

}