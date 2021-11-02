package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaRectangleBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaRhombBinding

class FormulaRhombFragment : Fragment() {

    private var _binding: FragmentFormulaRhombBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaRhombBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formulaArea = "$$ A = \\frac{(m)(n)}{2} = a * h $$"
        val formulaPerimetro = "$$ P = a * 4 $$"
        val formulaOtherOne = "$$ h = \\frac{(m)(n)}{2a} = a \\sin \\alpha $$"
        val formulaOtherTwo = "$$ \\alpha + \\beta = 180 $$"
        val formulaOtherThree = "$$ m^2 + n^2 = 4a^2 $$"
        binding.formulaArea.text = formulaArea
        binding.formulaPerimetro.text = formulaPerimetro
        binding.formulaOtherOne.text = formulaOtherOne
        binding.formulaOtherTwo.text = formulaOtherTwo
        binding.formulaOtherThree.text = formulaOtherThree
    }

}