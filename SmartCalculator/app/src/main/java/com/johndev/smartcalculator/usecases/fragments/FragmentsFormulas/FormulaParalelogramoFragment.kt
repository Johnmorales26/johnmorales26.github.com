package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaParalelogramoBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaRectangleBinding

class FormulaParalelogramoFragment : Fragment() {

    private var _binding: FragmentFormulaParalelogramoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaParalelogramoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ A = (b)(h) = ab\\sin \\mathbf a $$"
        val formulaPerimetro = "$$ P = (a + b) * 2 $$"
        val formulaOtherOne = "$$ h = a\\sin \\mathbf a =  a\\sin \\mathbf \\beta $$"
        val formulaOtherTwo = "$$ \\alpha + \\beta = 180 $$"
        val formulaOtherThree = "$$ m^2 + n^2 = 2(a^2 + b^2) $$"
        binding.formulaArea.text = formulaArea
        binding.formulaPerimetro.text = formulaPerimetro
        binding.formulaOtherOne.text = formulaOtherOne
        binding.formulaOtherTwo.text = formulaOtherTwo
        binding.formulaOtherThree.text = formulaOtherThree
    }

}