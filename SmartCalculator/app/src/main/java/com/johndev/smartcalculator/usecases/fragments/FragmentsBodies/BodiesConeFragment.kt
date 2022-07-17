package com.johndev.smartcalculator.usecases.fragments.FragmentsBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.MainActivity.Companion.sharedPreferences
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBodiesConeBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies
import com.johndev.smartcalculator.usecases.common.ViewDecimals

class BodiesConeFragment : Fragment() {

    private var _binding: FragmentBodiesConeBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseOperationHistory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodiesConeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bodies = FunctionsGeometryBodies(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val viewDecimals = ViewDecimals(requireContext())
                val radio = binding.etRadio.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble()

                val area = viewDecimals.selectedDecimals(bodies.totalAreaCone(radio, height).toDouble())
                val lateralArea = viewDecimals.selectedDecimals(bodies.lateralAreaCone(radio, height).toDouble())
                val volume = viewDecimals.selectedDecimals(bodies.volumeCone(radio, height).toDouble())

                with(binding){
                    tvArea.text = area
                    tvLateralArea.text = lateralArea
                    tvVolume.text = volume
                }

                database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!

                // Send data to History
                val operationHistory = OperationHistory(
                    nameFigure = getString(R.string.bodies_content_cone),
                    image = R.drawable.figura_cono_formulas,
                    radiusA = radio,
                    height = height,
                    area = area,
                    lateralArea = lateralArea,
                    volume = volume)
                val add = AddHistory()
                context?.let { it1 -> add.AddHistory(operationHistory, it1, binding.root) }
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