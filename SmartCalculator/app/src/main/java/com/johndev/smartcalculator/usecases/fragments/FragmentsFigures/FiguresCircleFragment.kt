package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresCircleBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresHexagonBinding
import com.johndev.smartcalculator.usecases.common.FunctionsAlgebra
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresCircleFragment : Fragment() {

    private var _binding: FragmentFiguresCircleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresCircleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val valueA = binding.etSideA.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaCircle(valueA)
                    tvDiameter.text = figures.diameterCircle(valueA)
                    tvCircumference.text = figures.circunferenceCircle(valueA)
                }
            }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etSideA.text.isNullOrEmpty()){
            binding.tilSideA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideA.error = null
        }
        return isValid
    }

}