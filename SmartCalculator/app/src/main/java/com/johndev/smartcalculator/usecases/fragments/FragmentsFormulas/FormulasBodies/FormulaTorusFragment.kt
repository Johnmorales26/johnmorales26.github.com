package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaSphericalSectorBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaTorusBinding

class FormulaTorusFragment : Fragment() {

    private var _binding: FragmentFormulaTorusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaTorusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ V = \\frac{1}{4} \\pi^2 (R + r)(R + r)^2 = 2 \\pi^2 b^2 a $$"
        val formulaPerimetro = "$$ A = \\pi^2 (R^2 - r^2) = 4 \\pi^2 ba $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}