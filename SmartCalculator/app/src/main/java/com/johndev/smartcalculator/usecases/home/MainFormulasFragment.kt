package com.johndev.smartcalculator.usecases.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainFormulasBinding
import com.johndev.smartcalculator.usecases.Adapters.FormulasAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.usecases.common.FormulasActivity
import com.squareup.picasso.Picasso

class MainFormulasFragment : Fragment(), OnClickListener {

    private var _binding: FragmentMainFormulasBinding? = null
    private val binding get() = _binding!!
    private lateinit var formulasAdapter: FormulasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainFormulasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataAlgebra = data("Algebra")
        formulasAdapter = FormulasAdapter(dataAlgebra, this)
        binding.rvAlgebraFormulas.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = formulasAdapter
        }

        val dataBodies = data("Bodies")
        formulasAdapter = FormulasAdapter(dataBodies, this)
        binding.rvBodiesFormulas.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = formulasAdapter
        }

        val dataForms = data("Forms")
        formulasAdapter = FormulasAdapter(dataForms, this)
        binding.rvFormsFormulas.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = formulasAdapter
        }

        binding.btnAlgebra.setOnClickListener {
            if (binding.rvAlgebraFormulas.visibility == VISIBLE){
                binding.rvAlgebraFormulas.visibility = GONE
                binding.btnAlgebra.setImageResource(R.drawable.ic_arrow_down)
            } else {
                binding.rvAlgebraFormulas.visibility = VISIBLE
                binding.btnAlgebra.setImageResource(R.drawable.ic_arrow_up)
            }
        }

        binding.btnForms.setOnClickListener {
            if (binding.rvFormsFormulas.visibility == VISIBLE){
                binding.rvFormsFormulas.visibility = GONE
                binding.btnForms.setImageResource(R.drawable.ic_arrow_down)
            } else {
                binding.rvFormsFormulas.visibility = VISIBLE
                binding.btnForms.setImageResource(R.drawable.ic_arrow_up)
            }
        }

        binding.btnBodies.setOnClickListener {
            if (binding.rvBodiesFormulas.visibility == VISIBLE){
                binding.rvBodiesFormulas.visibility = GONE
                binding.btnBodies.setImageResource(R.drawable.ic_arrow_down)
            } else {
                binding.rvBodiesFormulas.visibility = VISIBLE
                binding.btnBodies.setImageResource(R.drawable.ic_arrow_up)
            }
        }
    }

    private fun data(data: String): MutableList<Formulas> {
        return when(data) {
            "Algebra" -> {
                mutableListOf(
                    Formulas(1, getString(R.string.formula_polynomials)),
                    Formulas(2, getString(R.string.formula_fraction)),
                    Formulas(3, getString(R.string.formula_identity)),
                    Formulas(4, getString(R.string.formula_empowerment)),
                    Formulas(5, getString(R.string.formula_settlement)),
                    Formulas(6, getString(R.string.formula_the_summations)),
                    Formulas(7, getString(R.string.formula_decimal_logarithm)),
                    Formulas(8, getString(R.string.formula_natural_logarithm)))
                    //Formulas(9, getString(R.string.formula_Eulers_formula)))
            }
            "Bodies" -> {
                mutableListOf(
                    Formulas(1, getString(R.string.formula_sphere)),
                    Formulas(2, getString(R.string.formula_spherical_cap)),
                    Formulas(3, getString(R.string.formula_spherical_segment)),
                    Formulas(4, getString(R.string.formula_spherical_sector)),
                    Formulas(5, getString(R.string.formula_torus)),
                    Formulas(6, getString(R.string.formula_cylinder)),
                    Formulas(7, getString(R.string.formula_cone)),
                    Formulas(8, getString(R.string.formula_cone_trunk)),
                    Formulas(9, getString(R.string.formula_pyramid)),
                    Formulas(10, getString(R.string.formula_prism)),
                    Formulas(11, getString(R.string.formula_triangular_prism)))
            }
            "Forms" -> {
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