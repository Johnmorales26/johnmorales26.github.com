package com.johndev.smartcalculator.usecases.fragments.FragmentsOther.SecondaryMenus

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMainAlgebraBinding
import com.johndev.smartcalculator.databinding.FragmentMenuTimeBinding
import com.johndev.smartcalculator.usecases.Adapters.FunctionalitiesAdapter
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.principalViews.ConversionActivity

class MenuTimeFragment : Fragment() {

    private var _binding: FragmentMenuTimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMenuTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var optionSelected: Functionalities
        binding.cvOptionOne.setOnClickListener {
            optionSelected = Functionalities(1, getString(R.string.menu_time_time_difference), R.drawable.ic_time_difference)
            startStaticActivity(optionSelected)
        }
        binding.cvOptionTwo.setOnClickListener {
            optionSelected = Functionalities(1, getString(R.string.menu_time_add_time), R.drawable.ic_add_time)
            startStaticActivity(optionSelected)
        }
    }

    private fun startStaticActivity(functionalities: Functionalities){
        val intent = Intent(context, ConversionActivity::class.java).apply {
            putExtra(getString(R.string.key_function_id), functionalities.img.toString())
            putExtra(getString(R.string.key_function_name), functionalities.Nombre)
        }
        startActivity(intent)
    }

}