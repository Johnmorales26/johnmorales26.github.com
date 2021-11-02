package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresRectangleBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresRhombBinding
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresRhombFragment : Fragment() {

    private var _binding: FragmentFiguresRhombBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresRhombBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val height = binding.etHeight.text.toString().toDouble()
                val weight= binding.etWeight.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaRhomb(height, weight)
                    tvPerimeter.text = figures.perimeterRhomb(height, weight)
                }
            }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando Height
        if (binding.etHeight.text.isNullOrEmpty()){
            binding.etHeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etHeight.error = null
        }
        //  Evaluando Weight
        if (binding.etWeight.text.isNullOrEmpty()){
            binding.etWeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etWeight.error = null
        }
        return isValid
    }

}