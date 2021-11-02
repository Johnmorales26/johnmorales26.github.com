package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresPentagonBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresRectangleBinding
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresPentagonFragment : Fragment() {

    private var _binding: FragmentFiguresPentagonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresPentagonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaPentagon(sideA)
                    tvPerimeter.text = figures.perimeterPentagon(sideA)
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
        return isValid
    }

}