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
import com.johndev.smartcalculator.usecases.common.OperationsActivity

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
            FiguresAndBodies(0, getString(R.string.bodies_content_cube), R.drawable.cubo),
            FiguresAndBodies(1, getString(R.string.bodies_content_prism), R.drawable.prisma_rectangular),
            FiguresAndBodies(2, getString(R.string.bodies_content_pyramid), R.drawable.pyramid),
            FiguresAndBodies(3, getString(R.string.bodies_content_cut_pyramid), R.drawable.pyramid_cut),
            FiguresAndBodies(4, getString(R.string.bodies_content_cone), R.drawable.figura_cono_formulas),
            FiguresAndBodies(5, getString(R.string.bodies_content_cone_cut), R.drawable.figura_cono_formulas),
            FiguresAndBodies(6, getString(R.string.bodies_content_cylinder), R.drawable.cylinder),
            FiguresAndBodies(7, getString(R.string.bodies_content_sphere), R.drawable.sphere),
            FiguresAndBodies(8, getString(R.string.bodies_content_sphere_cap), R.drawable.sphere_cap),
            FiguresAndBodies(9, getString(R.string.bodies_content_sphere_segment), R.drawable.segmento_esfera),
            FiguresAndBodies(10, getString(R.string.bodies_content_ellipsoid), R.drawable.elipsoide)
        )
        return data
    }

}