package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresCircleBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresOvalBinding
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresOvalFragment : Fragment() {

    private var _binding: FragmentFiguresOvalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresOvalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val radioA = binding.etRadioA.text.toString().toDouble()
                val radioB = binding.etRadioB.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaOval(radioA, radioB)
                    tvPerimeter.text = figures.perimeterOval(radioA, radioB)
                }
            }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etRadioA.text.isNullOrEmpty()){
            binding.etRadioA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etRadioA.error = null
        }
        //  Evaluando value B
        if (binding.etRadioA.text.isNullOrEmpty()){
            binding.etRadioA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etRadioA.error = null
        }
        return isValid
    }

}