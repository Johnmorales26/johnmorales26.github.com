package com.johndev.smartcalculator.usecases.fragments.FragmentsFormulas.FormulasAlgebra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFormulasLogaritmoDecimalBinding
import com.johndev.smartcalculator.databinding.FragmentFormulasSumatoriasBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAlgebraAdapter
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasLogaritmoDecimalFragment : Fragment() {

    private var _binding: FragmentFormulasLogaritmoDecimalBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAlgebraAdaper: FormulasAlgebraAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasLogaritmoDecimalBinding.inflate(inflater, container, false)
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
            FormulasAlgebra(1, "$$ \\log_{10} N = lgN     (b=10) $$"),
            FormulasAlgebra(2, "$$ lgN = x \\Leftarrow\\Rightarrow 10^x = N $$")
        )
        return formulas
    }

}