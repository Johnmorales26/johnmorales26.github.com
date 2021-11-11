package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasRadicacionBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasSumatoriasBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAlgebraAdapter
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasSumatoriasFragment : Fragment() {

    private var _binding: FragmentFormulasSumatoriasBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAlgebraAdaper: FormulasAlgebraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasSumatoriasBinding.inflate(inflater, container, false)
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
            FormulasAlgebra(1, "$$ 1+2+3+...+(n+1)+n = \\frac{n(n+1)}{2} $$"),
            FormulasAlgebra(2, "$$ p+(p+1)+...+(q-1)+q = $$", "$$ \\frac{(q+p)(q-p+1)}{2} $$"),
            FormulasAlgebra(3, "$$ 1+3+5+...+(2n-3)+ $$", "$$ (2n-1)=n^2 $$"),
            FormulasAlgebra(4, "$$ 2+4+6+...+(2n-2)+2n $$", "$$ = n(n+1) $$"),
            FormulasAlgebra(5, "$$ 1^2+2^2+3^2+...+(n-1)^2+n^2 = $$", "$$ \\frac{n(n+1)(2n+1)}{6} $$"),
            FormulasAlgebra(6, "$$ 1^3+2^3+3^3+...+(n-1)^3+n^3 = $$", "$$ \\frac{n^2(n+1)^2}{4} $$"),
            FormulasAlgebra(7, "$$ 1^2+3^2+5^2+...+(2n-3)^2+ $$", "$$ (2n-1)^2 = \\frac{n(4n^2-1)}{3} $$"),
            FormulasAlgebra(8, "$$ 1^3+3^3+5^3+...+(2n-3)^3+ $$", "$$ (2n-1)^3 = n^2(2n^2-1) $$"),
            FormulasAlgebra(9, "$$ 1^4+2^4+3^4+...+(n-1)^4+n^4 = $$", "$$ \\frac{n(n+1)(2n+1)(3n^2+3n-1)}{30} $$")
        )
        return formulas
    }

}