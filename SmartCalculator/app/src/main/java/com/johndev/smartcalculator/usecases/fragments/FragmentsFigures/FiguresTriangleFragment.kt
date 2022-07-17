package com.johndev.smartcalculator.usecases.fragments.FragmentsFigures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentFiguresTriangleBinding
import com.johndev.smartcalculator.databinding.FragmentFormulaParalelogramoBinding
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryFigures

class FiguresTriangleFragment : Fragment() {

    private var _binding: FragmentFiguresTriangleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFiguresTriangleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val figures = FunctionsGeometryFigures(requireContext())
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val sideA = binding.etSideA.text.toString().toDouble()
                val sideB = binding.etSideB.text.toString().toDouble()
                val sideC = binding.etSideC.text.toString().toDouble()
                if (restrictions(sideA, sideB, sideC)){
                    with(binding){
                        val area = figures.areaTriangleEquilateral(sideA, sideB, sideC)
                        val perimeter = figures.perimeterTriangleScalane(sideA, sideB, sideC)
                        val anguloAB = figures.angleAB(sideA, sideB, sideC)
                        val anguloBC = figures.angleBC(sideA, sideB, sideC)
                        val anguloAC = figures.angleAC(sideA, sideB, sideC)
                        val alturaA = figures.heightA(sideA, sideB, sideC)
                        val alturaB = figures.heightB(sideA, sideB, sideC)
                        val alturaC = figures.heightC(sideA, sideB, sideC)

                        tvArea.text = area
                        tvPerimeter.text = perimeter
                        tvAnguloAB.text = anguloAB
                        tvAnguloBC.text = anguloBC
                        tvAnguloAC.text = anguloAC
                        tvAlturaA.text = alturaA
                        tvAlturaB.text = alturaB
                        tvAlturaC.text = alturaC
                        // Send data to History
                        val add = AddHistory()
                    }
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
        //  Evaluando value A
        if (binding.etSideB.text.isNullOrEmpty()){
            binding.etSideB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etSideB.error = null
        }
        //  Evaluando value A
        if (binding.etSideC.text.isNullOrEmpty()){
            binding.etSideC.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.etSideC.error = null
        }
        return isValid
    }

    private fun restrictions(sideA: Double = 0.0, sideB: Double = 0.0, sideC: Double = 0.0): Boolean {
        if (sideA > (sideB + sideC)) {
            binding.tvRestrictions.text = getString(R.string.error_not_triangle_a)
            visibilityVerification(false)
            return false
        }
        if (sideB > sideA + sideC) {
            binding.tvRestrictions.text = getString(R.string.error_not_triangle_b)
            visibilityVerification(false)
            return false
        }
        if (sideC > sideA + sideB) {
            binding.tvRestrictions.text = getString(R.string.error_not_triangle_c)
            visibilityVerification(false)
            return false
        }
        visibilityVerification(true)
        return true
    }

    private fun visibilityVerification(verification: Boolean) {
        when(verification){
            true -> {
                with(binding){
                    tvRestrictions.visibility = GONE
                    tvOutput.visibility = VISIBLE
                    cvArea.visibility = VISIBLE
                    cvPermeter.visibility = VISIBLE
                    cvAlturaA.visibility = VISIBLE
                    cvAlturaB.visibility = VISIBLE
                    cvAlturaC.visibility = VISIBLE
                    cvAnguloAB.visibility = VISIBLE
                    cvAnguloBC.visibility = VISIBLE
                    cvAnguloAC.visibility = VISIBLE
                }
            }
            false -> {
                with(binding){
                    tvRestrictions.visibility = VISIBLE
                    tvOutput.visibility = GONE
                    cvArea.visibility = GONE
                    cvPermeter.visibility = GONE
                    cvAlturaA.visibility = GONE
                    cvAlturaB.visibility = GONE
                    cvAlturaC.visibility = GONE
                    cvAnguloAB.visibility = GONE
                    cvAnguloBC.visibility = GONE
                    cvAnguloAC.visibility = GONE
                }
            }
        }
    }

}