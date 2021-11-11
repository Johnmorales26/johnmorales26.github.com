package com.johndev.smartcalculator.usecases.fragments.FragmentsBodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBodiesEllipsoidBinding
import com.johndev.smartcalculator.provider.services.DatabaseOperationHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.johndev.smartcalculator.usecases.common.AddHistory
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies

class BodiesEllipsoidFragment : Fragment() {

    private var _binding: FragmentBodiesEllipsoidBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseOperationHistory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodiesEllipsoidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bodies = FunctionsGeometryBodies()
        binding.btnResult.setOnClickListener{
            if (validFields()){
                val radioA = binding.etRadioA.text.toString().toDouble()
                val radioB = binding.etRadioB.text.toString().toDouble()
                val radioC = binding.etRadioC.text.toString().toDouble()
                with(binding){
                    val area = bodies.totalAreaEllipsoid(radioA, radioB, radioC)
                    val volume = bodies.volumeEllipsoid(radioA, radioB, radioC)
                    tvArea.text = area
                    tvVolume.text = volume

                    database = context?.let { it1 -> DatabaseOperationHistory(it1) }!!

                    // Send data to History
                    val operationHistory = OperationHistory(
                        nameFigure = getString(R.string.bodies_content_ellipsoid),
                        image = R.drawable.elipsoide,
                        radiusA = radioA,
                        radiusB = radioB,
                        radiusC = radioC,
                        area = area,
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
        if (binding.etRadioA.text.isNullOrEmpty()){
            binding.tilRadioA.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadioA.error = null
        }
        //  Evaluando value A
        if (binding.etRadioB.text.isNullOrEmpty()){
            binding.tilRadioB.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadioB.error = null
        }
        //  Evaluando value A
        if (binding.etRadioC.text.isNullOrEmpty()){
            binding.tilRadioC.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilRadioC.error = null
        }
        return isValid
    }

}