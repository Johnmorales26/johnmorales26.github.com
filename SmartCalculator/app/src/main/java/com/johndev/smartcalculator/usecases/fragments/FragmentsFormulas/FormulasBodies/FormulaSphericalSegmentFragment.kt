package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaSphericalCapBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaSphericalSegmentBinding

class FormulaSphericalSegmentFragment : Fragment() {

    private var _binding: FragmentFormulaSphericalSegmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaSphericalSegmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ V = \\frac{1}{6} \\pi h^3 + \\frac{1}{2} \\pi (r_1^2 + r_2^2) h $$"
        val formulaPerimetro = "$$ A = 2 \\pi Rh $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}