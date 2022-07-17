package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresCircleBinding
import com.johndev.smartcalculator.databinding.FragmentFiguresCircularArcBinding
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresCircularArcFragment : Fragment() {

    private var _binding: FragmentFiguresCircularArcBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresCircularArcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val angleA = binding.etAngleA.text.toString().toDouble()
                val radio = binding.etRadio.text.toString().toDouble()
                with(binding){
                    tvArea.text = figures.areaCircularArc(angleA, radio)
                    tvPerimeter.text = figures.perimeterCircularArc(angleA, radio)
                }
            }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etRadio.text.isNullOrEmpty()){
            binding.tilRadio.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadio.error = null
        }
        //  Evaluando value B
        if (binding.etAngleA.text.isNullOrEmpty()){
            binding.tilAngleA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilAngleA.error = null
        }
        return isValid
    }

}