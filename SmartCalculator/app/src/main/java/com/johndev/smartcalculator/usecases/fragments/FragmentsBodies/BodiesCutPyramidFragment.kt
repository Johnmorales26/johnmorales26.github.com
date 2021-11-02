package com.johndev.smartcalculator.usecases.fragments.FragmentsBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBodiesCubeBinding
import com.johndev.smartcalculator.databinding.FragmentBodiesCutPyramidBinding
import com.johndev.smartcalculator.databinding.FragmentBodiesPyramidBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies

class BodiesCutPyramidFragment : Fragment() {

    private var _binding: FragmentBodiesCutPyramidBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseOperationHistory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodiesCutPyramidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bodies = FunctionsGeometryBodies()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    val area = bodies.totalAreaShortPyramid(sideA, sideB, height)
                    val lateralArea = bodies.lateralAreaShortPyramid(sideA, sideB, height)
                    val volume = bodies.volumeShortPyramid(sideA, sideB, height)
                    tvArea.text = area
                    tvLateralArea.text = lateralArea
                    tvVolume.text = volume

                    database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!

                    // Send data to History
                    val operationHistory = OperationHistory(
                        nameFigure = getString(R.string.bodies_content_cut_pyramid),
                        image = R.drawable.pyramid_cut,
                        sideA = sideA,
                        sideB = sideB,
                        height = height,
                        area = area,
                        lateralArea = lateralArea,
                        volume = volume)
                    val add = AddHistory()
                    context?.let { it1 -> add.AddHistory(operationHistory, it1, binding.root) }
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
        //  Evaluando value B
        if (binding.etSideB.text.isNullOrEmpty()){
            binding.tilSideB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideB.error = null
        }
        //  Evaluando value C
        if (binding.etHeight.text.isNullOrEmpty()){
            binding.tilHeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilHeight.error = null
        }
        return isValid
    }

}