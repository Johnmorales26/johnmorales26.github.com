package com.johndev.smartcalculator.usecases.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainAlgebraBinding
import com.johndev.smartcalculator.usecases.Adapters.FunctionalitiesAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.*
import com.johndev.smartcalculator.usecases.common.OperationsActivity
import android.util.Pair

class MainAlgebraFragment : Fragment(), OnClickListener {

    private var _binding: FragmentMainAlgebraBinding? = null
    private val binding get() = _binding!!
    private lateinit var functionalitiesAdapter: FunctionalitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainAlgebraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = data("Algebra")
        functionalitiesAdapter = FunctionalitiesAdapter(data, this)
        binding.rvAlgebra.apply {
            //layoutManager = LinearLayoutManager(context)
            layoutManager = GridLayoutManager(context, 2)
            adapter = functionalitiesAdapter
        }
        data = data("Geometria")
        functionalitiesAdapter = FunctionalitiesAdapter(data, this)
        binding.rvGeometria.apply {
            //layoutManager = LinearLayoutManager(context)
            layoutManager = GridLayoutManager(context, 2)
            adapter = functionalitiesAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(functionalities: Functionalities, imgPhoto: View, tvNombre: View) {
        val intent = Intent(context, OperationsActivity::class.java).apply {
            putExtra(getString(R.string.key_function_id), functionalities.img.toString())
            putExtra(getString(R.string.key_function_name), functionalities.Nombre)
        }
        val imgPair: Pair<View, String> = Pair.create(imgPhoto, imgPhoto.transitionName.toString())
        val namePair: Pair<View, String> = Pair.create(tvNombre, tvNombre.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(activity,
                imgPair, namePair)
            .toBundle()
        startActivity(intent, options)
    }

    override fun onClick(formula: Formulas, tvNombre: View) {}
    override fun onClick(secondaryMenus: SecondaryMenus, imgPhoto: View, tvNombre: View) {}
    override fun onClick(figuresOrBodies: FiguresAndBodies, imgPhoto: View, tvNombre: View) {}

    private fun data(typeData: String): MutableList<Functionalities> {
        return when(typeData) {
            "Algebra" -> {
                mutableListOf(
                    Functionalities("0", getString(R.string.functions_content_percent), R.drawable.percent),
                    Functionalities("1", getString(R.string.functions_content_average), R.drawable.average),
                    Functionalities("2", getString(R.string.functions_content_proportion), R.drawable.proportion),
                    Functionalities("3", getString(R.string.functions_content_ecuations), R.drawable.ecuations),
                    Functionalities("4", getString(R.string.functions_content_fractions), R.drawable.fractions),
                    Functionalities("5", getString(R.string.functions_content_mcd_mcm), R.drawable.mcd_mcm),
                    Functionalities("6", getString(R.string.functions_content_combinations), R.drawable.combinations),
                    Functionalities("7", getString(R.string.functions_content_prime_numbers), R.drawable.prime_numbers),
                    Functionalities("8", getString(R.string.functions_content_number_generator), R.drawable.number_generator)
                )
            }
            "Geometria" -> {
                mutableListOf(
                    Functionalities("1", getString(R.string.functions_content_forms), R.drawable.figuras_geometricas),
                    Functionalities("2", getString(R.string.functions_content_bodies), R.drawable.cubo)
                )
            }
            else -> {
                mutableListOf(
                    Functionalities("1", getString(R.string.functions_content_dont_exist_data), R.drawable.ic_launcher_foreground)
                )
            }
        }
    }

}