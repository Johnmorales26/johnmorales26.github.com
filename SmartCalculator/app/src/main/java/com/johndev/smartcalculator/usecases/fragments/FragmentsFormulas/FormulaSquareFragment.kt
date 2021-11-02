package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaSquareBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaTriangleBinding

class FormulaSquareFragment : Fragment() {

    private var _binding: FragmentFormulaSquareBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaSquareBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val tex = "This come from string. You can insert inline formula:" +
        //       " \\(ax^2 + bx + c = 0\\) " +
        //       "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$"

        val formulaArea = "$$ A = a^2 $$"
        val formulaDiametro = "$$ d = a * \\sqrt 2 $$"
        val formulaPerimetro = "$$ P = 4 * a $$"
        binding.formulaArea.text = formulaArea
        binding.formulaPerimetro.text = formulaPerimetro
        binding.formulaDiametro.text = formulaDiametro
    }

}