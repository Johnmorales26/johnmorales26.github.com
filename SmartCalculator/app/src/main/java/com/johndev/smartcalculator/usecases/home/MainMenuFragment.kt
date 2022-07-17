package com.johndev.smartcalculator.usecases.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
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
import com.johndev.smartcalculator.usecases.principalViews.OperationsActivity
import android.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.usecases.principalViews.ConversionActivity

class MainMenuFragment : Fragment(), OnClickListener {

    private var _binding: FragmentMainAlgebraBinding? = null
    private val binding get() = _binding!!
    private lateinit var functionalitiesAdapter: FunctionalitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        data = data("Conversiones")
        functionalitiesAdapter = FunctionalitiesAdapter(data, this)
        binding.rvConversiones.apply {
            //layoutManager = LinearLayoutManager(context)
            layoutManager = GridLayoutManager(context, 2)
            adapter = functionalitiesAdapter
        }
        data = data("Otros")
        functionalitiesAdapter = FunctionalitiesAdapter(data, this)
        binding.rvOtros.apply {
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
        when (functionalities.id) {
            1, 2, 3, 4, 5, 6, 7, 8, 9 -> {
                startScrollActivity(functionalities, imgPhoto, tvNombre)
            }
            21, 22 -> {
                startScrollActivity(functionalities, imgPhoto, tvNombre)
            }
            41, 42, 43, 44, 45, 46 -> {
                startStaticActivity(functionalities, imgPhoto, tvNombre)
            }
            61, 62, 63, 64, 65, 66 -> {
                startScrollActivity(functionalities, imgPhoto, tvNombre)
            }
        }
    }

    private fun startScrollActivity(functionalities: Functionalities, imgPhoto: View, tvNombre: View){
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

    private fun startStaticActivity(functionalities: Functionalities, imgPhoto: View, tvNombre: View){
        val intent = Intent(context, ConversionActivity::class.java).apply {
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
                    Functionalities(1, getString(R.string.functions_content_percent), R.drawable.ic_percent),
                    Functionalities(2, getString(R.string.functions_content_average), R.drawable.ic_average),
                    Functionalities(3, getString(R.string.functions_content_proportion), R.drawable.ic_proportion),
                    Functionalities(4, getString(R.string.functions_content_ecuations), R.drawable.ic_ecuations),
                    Functionalities(5, getString(R.string.functions_content_fractions), R.drawable.ic_fractions),
                    Functionalities(6, getString(R.string.functions_content_mcd_mcm), R.drawable.ic_mcd_mcm),
                    Functionalities(7, getString(R.string.functions_content_combinations), R.drawable.ic_combinations),
                    Functionalities(8, getString(R.string.functions_content_prime_numbers), R.drawable.ic_prime_numbers),
                    Functionalities(9, getString(R.string.functions_content_number_generator), R.drawable.number_generator)
                )
            }
            "Geometria" -> {
                mutableListOf(
                    Functionalities(21, getString(R.string.functions_content_forms), R.drawable.ic_square),
                    Functionalities(22, getString(R.string.functions_content_bodies), R.drawable.ic_cube)
                )
            }
            "Conversiones" -> {
                mutableListOf(
                    Functionalities(41, getString(R.string.functions_content_acceleration), R.drawable.ic_aceleration),
                    Functionalities(42, getString(R.string.functions_content_data_storage), R.drawable.ic_data_storage),
                    Functionalities(43, getString(R.string.functions_content_angle), R.drawable.ic_angle)
                    //Functionalities(44, getString(R.string.functions_content_area), R.drawable.ic_area),
                    //Functionalities(45, getString(R.string.functions_content_energy), R.drawable.ic_energy),
                    //Functionalities(46, getString(R.string.functions_content_strenght), R.drawable.ic_streght)
                )
            }
            "Otros" -> {
                mutableListOf(
                    Functionalities(61, getString(R.string.functions_content_age), R.drawable.ic_birthday),
                    //Functionalities(62, getString(R.string.functions_content_date), R.drawable.ic_date),
                    //Functionalities(63, getString(R.string.functions_content_time), R.drawable.ic_time),
                    Functionalities(64, getString(R.string.functions_content_body_mass), R.drawable.ic_body_mass),
                    Functionalities(65, getString(R.string.functions_content_ohm), R.drawable.ic_ohm),
                    Functionalities(66, getString(R.string.functions_content_fibonacci), R.drawable.ic_fibonacci)
                )
            }
            else -> {
                mutableListOf(
                    Functionalities(0, getString(R.string.functions_content_dont_exist_data), R.drawable.ic_launcher_foreground)
                )
            }
        }
    }

}