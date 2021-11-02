package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresRectangleBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresTrapezoideBinding
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresTrapezoideFragment : Fragment() {

    private var _binding: FragmentFiguresTrapezoideBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresTrapezoideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaTrapezoid(sideA, sideB, height)
                    tvPerimeter.text = figures.perimeterTrapezoid(sideA, sideB, height)
                }
            }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etSideA.text.isNullOrEmpty()){
            binding.etSideA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etSideA.error = null
        }
        //  Evaluando value B
        if (binding.etSideB.text.isNullOrEmpty()){
            binding.etSideB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etSideB.error = null
        }
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
        return isValid
    }


}