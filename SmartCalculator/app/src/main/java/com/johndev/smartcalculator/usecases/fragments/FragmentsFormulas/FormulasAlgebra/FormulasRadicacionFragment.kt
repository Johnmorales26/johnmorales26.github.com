package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasPotenciacionBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasRadicacionBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAlgebraAdapter
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasRadicacionFragment : Fragment() {

    private var _binding: FragmentFormulasRadicacionBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAlgebraAdaper: FormulasAlgebraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasRadicacionBinding.inflate(inflater, container, false)
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
            FormulasAlgebra(1, "$$ (\\sqrt[n]{a})^n = a $$"),
            FormulasAlgebra(2, "$$ \\sqrt[n]{a^m} = \\sqrt[n.p]{a^{m.p}} $$"),
            FormulasAlgebra(3, "$$ (\\sqrt[n]{a})^m = \\sqrt[n]{a^m} = a^{m/n} $$"),
            FormulasAlgebra(4, "$$ \\sqrt[n]{a.b} = \\sqrt[n]{a} . \\sqrt[n]{b} $$"),
            FormulasAlgebra(5, "$$ \\sqrt[n]{\\frac{a}{b}} = \\frac{\\sqrt[n]{a}}{\\sqrt[n]{b}}, (b \\neq 0) $$"),
            FormulasAlgebra(6, "$$ \\sqrt[n]{\\sqrt[m]{a}} = \\sqrt[n.m]{a} $$"),
            FormulasAlgebra(7, "$$ \\sqrt[n]{a} \\sqrt[m]{b} == \\sqrt[nm]{a^mb^n} $$"),
            FormulasAlgebra(8, "$$ \\frac{\\sqrt[n]{a}}{\\sqrt[m]{b}} = \\frac{\\sqrt[nm]{a^m}}{\\sqrt[mn]{b^n}} = \\sqrt[nm]{\\frac{a^m}{b^n}} $$"),
            FormulasAlgebra(9, "$$ \\frac{x}{\\sqrt[n]{a}} = \\frac{x\\sqrt[n]{a^{n-1}}}{a}, (a \\neq 0) $$"),
            FormulasAlgebra(10, "$$ \\frac{x}{\\sqrt{a} \\pm \\sqrt{b}} = \\frac{x(\\sqrt{a} \\mp \\sqrt{b})}{a-b} $$")
        )
        return formulas
    }
}