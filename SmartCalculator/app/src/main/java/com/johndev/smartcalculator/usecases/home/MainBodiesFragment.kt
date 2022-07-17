package com.johndev.smartcalculator.usecases.home

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
import com.johndev.smartcalculator.databinding.FragmentMainBodiesBinding
import com.johndev.smartcalculator.usecases.Adapters.FiguresAndBodiesAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.usecases.principalViews.OperationsActivity

class MainBodiesFragment : Fragment(), OnClickListener {

    private var _binding: FragmentMainBodiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var figuresAndBodiesAdapter: FiguresAndBodiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBodiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        figuresAndBodiesAdapter = FiguresAndBodiesAdapter(data(), this)
        binding.rBodies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = figuresAndBodiesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(functionalities: Functionalities, imgPhoto: View, tvNombre: View) {}
    override fun onClick(secondaryMenus: SecondaryMenus, imgPhoto: View, tvNombre: View) {}
    override fun onClick(formula: Formulas, tvNombre: View) {}
    override fun onClick(figuresOrBodies: FiguresAndBodies, imgPhoto: View, tvNombre: View) {
        val intent = Intent(context, OperationsActivity::class.java).apply {
            putExtra(getString(R.string.key_function_id), figuresOrBodies.imgPhoto.toString())
            putExtra(getString(R.string.key_function_name), figuresOrBodies.nombre)
        }
        val imgPair: Pair<View, String> = Pair.create(imgPhoto, imgPhoto.transitionName.toString())
        val namePair: Pair<View, String> = Pair.create(tvNombre, tvNombre.transitionName)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(activity,
                imgPair, namePair)
            .toBundle()
        startActivity(intent, options)
    }

    private fun data(): MutableList<FiguresAndBodies> {
        val data = mutableListOf(
            FiguresAndBodies(0, getString(R.string.bodies_content_cube), R.drawable.ic_cube),
            FiguresAndBodies(1, getString(R.string.bodies_content_prism), R.drawable.ic_rectangle_prism),
            FiguresAndBodies(2, getString(R.string.bodies_content_pyramid), R.drawable.ic_pyramid),
            FiguresAndBodies(3, getString(R.string.bodies_content_cut_pyramid), R.drawable.ic_pyramid),
            FiguresAndBodies(4, getString(R.string.bodies_content_cone), R.drawable.ic_cone),
            FiguresAndBodies(5, getString(R.string.bodies_content_cone_cut), R.drawable.ic_cone),
            FiguresAndBodies(6, getString(R.string.bodies_content_cylinder), R.drawable.cylinder),
            FiguresAndBodies(7, getString(R.string.bodies_content_sphere), R.drawable.ic_sphere),
            FiguresAndBodies(8, getString(R.string.bodies_content_sphere_cap), R.drawable.ic_sphere_tapa),
            FiguresAndBodies(9, getString(R.string.bodies_content_sphere_segment), R.drawable.ic_sphere_segment),
            FiguresAndBodies(10, getString(R.string.bodies_content_ellipsoid), R.drawable.ic_ellipsoid)
        )
        return data
    }

}