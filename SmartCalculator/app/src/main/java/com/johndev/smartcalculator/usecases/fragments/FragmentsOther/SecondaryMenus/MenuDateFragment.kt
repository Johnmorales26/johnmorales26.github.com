package com.johndev.smartcalculator.usecases.fragments.FragmentsOther.SecondaryMenus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentMenuDateBinding
import com.johndev.smartcalculator.databinding.FragmentOtherAgeBinding
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.johndev.smartcalculator.usecases.principalViews.ConversionActivity

class MenuDateFragment : Fragment() {

    private var _binding: FragmentMenuDateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuDateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var optionSelected: Functionalities
        binding.cvOptionOne.setOnClickListener {
            optionSelected = Functionalities(1, getString(R.string.menu_date_date_difference), R.drawable.ic_date_difference)
            startStaticActivity(optionSelected)
        }
        binding.cvOptionTwo.setOnClickListener {
            optionSelected = Functionalities(1, getString(R.string.menu_date_date_add), R.drawable.ic_add_date)
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