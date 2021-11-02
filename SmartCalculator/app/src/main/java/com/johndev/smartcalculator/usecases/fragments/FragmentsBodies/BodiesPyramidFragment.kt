package com.johndev.smartcalculator.usecases.fragments.FragmentsBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBodiesPyramidBinding
import com.johndev.smartcalculator.databinding.FragmentBodiesRectangularPrismBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies

class BodiesPyramidFragment : Fragment() {

    private var _binding: FragmentBodiesPyramidBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseOperationHistory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodiesPyramidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bodies = FunctionsGeometryBodies()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()
                with(binding){
                    val area = bodies.totalAreaPyramid(sideA, height)
                    val lateralArea= bodies.lateralAreaPyramid(sideA, height)
                    val volume = bodies.volumePyramid(sideA, height)
                    tvArea.text = area
                    tvLateralArea.text = lateralArea
                    tvVolume.text = volume

                    database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!

                    // Send data to History
                    val operationHistory = OperationHistory(
                        nameFigure = getString(R.string.bodies_content_pyramid),
                        image = R.drawable.pyramid,
                        sideA = sideA,
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