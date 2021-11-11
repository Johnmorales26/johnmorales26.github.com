package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasForms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContanierAverageBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaTriangleBinding

class FormulaTriangleFragment : Fragment() {

    private var _binding: FragmentFormulaTriangleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaTriangleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val tex = "This come from string. You can insert inline formula:" +
         //       " \\(ax^2 + bx + c = 0\\) " +
         //       "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$"

        val formulaArea = "$$\\frac{(b)(h)}{2} = A$$"
        val formulaAreaOther = "$$\\sqrt s(s - a)(s -b)(s -c) = A$$"
        val formulaPerimetro = "$$ L + L + L = P $$"
        binding.formulaArea.text = formulaArea
        binding.formulaAreaOther.text = formulaAreaOther
        binding.formulaPerimetro.text = formulaPerimetro
    }

}