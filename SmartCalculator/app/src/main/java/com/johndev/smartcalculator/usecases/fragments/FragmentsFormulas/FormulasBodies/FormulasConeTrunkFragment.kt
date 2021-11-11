package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaConeBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasConeTrunkBinding

class FormulasConeTrunkFragment : Fragment() {

    private var _binding: FragmentFormulasConeTrunkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasConeTrunkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ V = \\frac{1}{3} \\pi h (R^2 + r^2 + Rr) $$"
        val formulaPerimetro = "$$ A = \\pi (R + r)s = \\pi (R + r) \\sqrt{h^2 + (R - r)} $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}