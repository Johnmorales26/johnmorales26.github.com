package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaSphericalCapBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasSpehreBinding

class FormulaSphericalCapFragment : Fragment() {

    private var _binding: FragmentFormulaSphericalCapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaSphericalCapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$\\pi h^2(R - \\frac{h}{3}) = \\frac{1}{6} \\pi h (h^2 + 3 r^2) = V$$"
        val formulaPerimetro = "$$ A = 2\\pi Rh = \\pi (r^2 + h^2) $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}