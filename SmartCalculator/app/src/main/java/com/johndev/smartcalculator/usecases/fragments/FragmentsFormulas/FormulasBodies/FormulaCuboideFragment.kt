package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulaCuboideBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasConeTrunkBinding

class FormulaCuboideFragment : Fragment() {

    private var _binding: FragmentFormulaCuboideBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaCuboideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaArea = "$$ V = lwh $$"
        val formulaPerimetro = "$$ A = 2(lw + wh + hl) $$"
        binding.formulaVolume.text = formulaArea
        binding.formulaSurface.text = formulaPerimetro
    }

}