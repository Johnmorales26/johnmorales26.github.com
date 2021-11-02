package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.johndev.smartcalculator.databinding.FragmentFormulaRhombBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaTrapezoideBinding


class FormulaTrapezoideFragment : Fragment() {

    private var _binding: FragmentFormulaTrapezoideBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaTrapezoideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formulaArea = "$$ A = h * \\frac{a + b}{2} = hq $$"
        val formulaQ = "$$ q = \\frac{a + b}{2} $$"
        binding.formulaArea.text = formulaArea
        binding.formulaOtherOne.text = formulaQ
    }
}