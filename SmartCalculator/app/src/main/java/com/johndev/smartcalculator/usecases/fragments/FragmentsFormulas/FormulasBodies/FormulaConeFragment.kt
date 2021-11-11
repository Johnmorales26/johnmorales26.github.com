package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaConeBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaCylinderBinding

class FormulaConeFragment : Fragment() {

    private var _binding: FragmentFormulaConeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaConeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ V = \\frac{\\pi r^2 h}{3} $$"
        val formulaPerimetro = "$$ A = \\pi rh $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}