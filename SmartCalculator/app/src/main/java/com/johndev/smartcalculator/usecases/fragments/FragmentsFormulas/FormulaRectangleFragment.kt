package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaRectangleBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaTriangleBinding

class FormulaRectangleFragment : Fragment() {

    private var _binding: FragmentFormulaRectangleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaRectangleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ A = a * b $$"
        val formulaDiametro = "$$ d = \\sqrt a^2 + b^2 $$"
        val formulaPerimetro = "$$ P = (a + b) * 2 $$"
        binding.formulaArea.text = formulaArea
        binding.formulaPerimetro.text = formulaPerimetro
        binding.formulaDiametro.text = formulaDiametro
    }

}