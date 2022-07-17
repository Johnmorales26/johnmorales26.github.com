package com.johndev.smartcalculator.usecases.fragments.FragmentsFunctions

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentContainerEcuationsBinding
import com.johndev.smartcalculator.usecases.Adapters.SecondaryMenusAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.usecases.principalViews.OperationsSecondaryActivity

class ContainerEcuationsFragment : Fragment(), OnClickListener {

    private var _binding: FragmentContainerEcuationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var secondaryMenusAdapter: SecondaryMenusAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContainerEcuationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        secondaryMenusAdapter = SecondaryMenusAdapter(data(), this)
        binding.rcSecondaryMenu.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = secondaryMenusAdapter
        }
    }

    override fun onClick(secondaryMenus: SecondaryMenus, imgPhoto: View, tvNombre: View) {
        val intent = Intent(context, OperationsSecondaryActivity::class.java).apply {
            putExtra(getString(R.string.key_function_id), secondaryMenus.img.toString())
            putExtra(getString(R.string.key_function_name), secondaryMenus.nombre)
        }
        val imgPair: Pair<View, String> = Pair.create(imgPhoto, imgPhoto.transitionName.toString())
        val namePair: Pair<View, String> = Pair.create(tvNombre, tvNombre.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(activity,
                imgPair, namePair)
            .toBundle()
        startActivity(intent, options)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun data(): MutableList<SecondaryMenus> {
        val data = mutableListOf(
            SecondaryMenus(
                0,
                R.drawable.ic_lineal_ecuations,
                getString(R.string.menu_options_lineal_ecuations),
                getString(R.string.formula_options_lineal_ecuation)
            ),
            SecondaryMenus(
                1,
                R.drawable.ic_quadratic_ecuations,
                getString(R.string.menu_options_quadratics_ecuations),
                getString(R.string.formula_options_quadratics_ecuations)
            )
        )
        return data
    }

    override fun onClick(functionalities: Functionalities, imgPhoto: View, tvNombre: View) {}
    override fun onClick(figuresOrBodies: FiguresAndBodies, imgPhoto: View, tvNombre: View) {}
    override fun onClick(formula: Formulas, tvNombre: View) {}
}