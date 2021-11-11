package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasFractionBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasIdentidadBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAlgebraAdapter
import com.johndev.smartcalculator.usecases.Adapters.FunctionalitiesAdapter
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra
import com.johndev.smartcalculator.usecases.base.Functionalities


class FormulasIdentidadFragment : Fragment() {

    private var _binding: FragmentFormulasIdentidadBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAlgebraAdaper: FormulasAlgebraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasIdentidadBinding.inflate(inflater, container, false)
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
            FormulasAlgebra(1, "$$ (a \\pm b)^2 a^2 \\pm 2ab + b^2 $$"),
            FormulasAlgebra(2, "$$ (a \\pm b)^3 a^3 \\pm 3a^3 b + 3ab^2 + b^3 $$"),
            FormulasAlgebra(3, "$$ (a \\pm b)^4 a^4 \\pm 4a^3 b + 6a^2 b^2 \\pm 4ab^3 + b^4 $$"),
            FormulasAlgebra(4, "$$ (a + b + c)^2 = a^2 + b^2 + c^2 + $$", "$$ 2ab + 2ac + 2bc $$"),
            FormulasAlgebra(5, "$$ (a + b - c)^2 = a^2 + b^2 + c^2 + $$", "$$ 2ab - 2ac - 2bc $$"),
            FormulasAlgebra(6, "$$ (a - b - c)^2 = a^2 + b^2 + c^2 - $$", "$$ 2ab - 2ac + 2bc $$"),
            FormulasAlgebra(7, "$$ (a + b + c)^3 = a^3 + b^3 + c^3 + 6abc $$",
                "$$ + 3(a^2 b + ab^2 + b^2 c + bc^2 + c^2 a + ca^2) $$"),
            FormulasAlgebra(8, "$$ (a_1 + b_2 + ... a_n)^2 = a_1^2 + a2^2 + ... a_n^2 $$",
                "$$ + 2(a_1 a_2 + a_1 a_3 + ... a_{n-1} a_n $$"),
            FormulasAlgebra(9, "$$ a^2 - b^2 = (a - b)(a + b) $$"),
            FormulasAlgebra(10, "$$ a^3 + b^3 = (a + b)(a^2 - ab + b^2) $$"),
            FormulasAlgebra(11, "$$ a^3 - b^3 = (a - b)(a^2 + ab + b^2) $$"),
            FormulasAlgebra(12, "$$ a^4 + a^4 = (a^2 + b^2)^2 - 2a^2b^2 = $$",
                "$$ a^2 \\sqrt{2ab} + b^2)(a^2 - \\sqrt{2ab} + b^2) $$"),
            FormulasAlgebra(13, "$$ a^4 - b^4 = (a^2 - b^2)(a^2 + b^2) = $$",
                "$$ (a + b)(a - b)(a^2 + b^2) $$"),
            FormulasAlgebra(14, "$$ a^5 + b^5 = (a + b)(a^4 - a^3b + $$",
                "$$ a^2b^2 - ab^3 + b^4) $$"),
            FormulasAlgebra(15, "$$ a^5-b^5 = (a-b)(a^4 + a^3b + $$",
                "$$ a^2b^2 + ab^3 b^4) $$")
        )
        return formulas
    }
}