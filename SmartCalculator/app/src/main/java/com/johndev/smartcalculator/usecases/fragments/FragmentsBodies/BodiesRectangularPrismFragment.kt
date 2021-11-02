package com.johndev.smartcalculator.usecases.fragments.FragmentsBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBodiesCubeBinding
import com.johndev.smartcalculator.databinding.FragmentBodiesRectangularPrismBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies

class BodiesRectangularPrismFragment : Fragment() {

    private var _binding: FragmentBodiesRectangularPrismBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseOperationHistory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodiesRectangularPrismBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bodies = FunctionsGeometryBodies()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val sideC = binding.etSideC.text.toString().toDouble()
                with(binding){
                    val area = bodies.totalAreaPrism(sideA, sideB, sideC)
                    val lateralArea = bodies.lateralAreaPrism(sideA, sideB, sideC)
                    val volume = bodies.volumePrism(sideA, sideB, sideC)
                    tvArea.text = area
                    tvLateralArea.text = lateralArea
                    tvVolume.text = volume

                    database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!

                    // Send data to History
                    val operationHistory = OperationHistory(
                        nameFigure = getString(R.string.bodies_content_prism),
                        image = R.drawable.prisma_rectangular,
                        sideA = sideA,
                        sideB = sideB,
                        sideC = sideC,
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
        if (binding.etSideC.text.isNullOrEmpty()){
            binding.tilSideC.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilSideC.error = null
        }
        return isValid
    }

}