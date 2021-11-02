package com.johndev.smartcalculator.usecases.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainAlgebraBinding
import com.johndev.smartcalculator.databinding.FragmentMainFormulasBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAdapter
import com.johndev.smartcalculator.usecases.Adapters.FunctionalitiesAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.usecases.common.FormulasActivity
import com.johndev.smartcalculator.usecases.common.OperationsActivity

class MainFormulasFragment : Fragment(), OnClickListener {

    private var _binding: FragmentMainFormulasBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAdapter: FormulasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainFormulasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data = data("Algebra")
        formulasAdapter = FormulasAdapter(data, this)
        binding.rvAlgebraFormulas.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = formulasAdapter
        }
    }

    private fun data(data: String): MutableList<Formulas> {
        return when(data) {
            "Algebra" -> {
                mutableListOf(
                    Formulas(1, getString(R.string.formula_triangle)),
                    Formulas(2, getString(R.string.formula_right_triangle)),
                    Formulas(3, getString(R.string.formula_square)),
                    Formulas(4, getString(R.string.formula_rectangle)),
                    Formulas(5, getString(R.string.formula_parallelogram)),
                    Formulas(6, getString(R.string.formula_rhomb)),
                    Formulas(7, getString(R.string.formula_trapezoid)))
            }
            else -> {
                mutableListOf(
                    Formulas(1, "No Exist Data"))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(formula: Formulas, tvNombre: View) {
        val intent = Intent(context, FormulasActivity::class.java).apply {
            putExtra(getString(R.string.key_function_name), formula.Nombre)
        }
        /*val namePair: Pair<View, String> = Pair.create(tvNombre, tvNombre.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(activity, namePair)
            .toBundle()
        startActivity(intent, options)*/
        startActivity(intent)
    }

    override fun onClick(functionalities: Functionalities, imgPhoto: View, tvNombre: View) {}
    override fun onClick(secondaryMenus: SecondaryMenus, imgPhoto: View, tvNombre: View) {}
    override fun onClick(figuresOrBodies: FiguresAndBodies, imgPhoto: View, tvNombre: View) {}
}