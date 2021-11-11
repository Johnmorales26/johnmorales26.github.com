package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasIdentidadBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasPotenciacionBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAlgebraAdapter
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasPotenciacionFragment : Fragment() {

    private var _binding: FragmentFormulasPotenciacionBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAlgebraAdaper: FormulasAlgebraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasPotenciacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = data()
        formulasAlgebraAdaper = FormulasAlgebraAdapter(data)
        binding.rvFormulas.apply {
            layoutManager = LinearLayoutManager(context)
            //layoutManager = GridLayoutManager(context, 2)
            adapter = formulasAlgebraAdaper
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun data(): MutableList<FormulasAlgebra> {
        val formulas: MutableList<FormulasAlgebra> = mutableListOf(
            FormulasAlgebra(1, "$$ \\frac{a^m}{a^n} = a^{m-n} $$"),
            FormulasAlgebra(2, "$$ (\\frac{a}{b})^m = \\frac{a^m}{b^m} , (b \\neq 0) $$"),
            FormulasAlgebra(3, "$$ a^m . a^n = a^{m+n} $$"),
            FormulasAlgebra(4, "$$ (a.b)^m = a^mb^m $$"),
            FormulasAlgebra(5, "$$ a^{1/n} = \\sqrt{a} $$"),
            FormulasAlgebra(6, "$$ (a^m)^n = a^{mn} $$"),
            FormulasAlgebra(7, "$$ a^0 = 1, (a \\neq 0) $$"),
            FormulasAlgebra(8, "$$ a^{-m} = \\frac{1}{a^m} , (a \\neq 0) $$"),
            FormulasAlgebra(9, "$$ a^{\\frac{m}{n}} = \\sqrt[n]{a^m} $$")
        )
        return formulas
    }

}