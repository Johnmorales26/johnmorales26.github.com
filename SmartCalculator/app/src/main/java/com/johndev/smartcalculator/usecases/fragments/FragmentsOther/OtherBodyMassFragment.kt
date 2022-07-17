package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import IMC.FormatResults
import IMC.IMC
import IMC.NivelIMC
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOnboardingAlgebraBinding
import com.johndev.smartcalculator.databinding.FragmentOtherBodyMassBinding

class OtherBodyMassFragment : Fragment() {

    private var _binding: FragmentOtherBodyMassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBodyMassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnResult.setOnClickListener { realiseOperation() }
        binding.chipMetrico.setOnClickListener {
            binding.apply {
                chipImperial.isChecked = false
                etFT.text?.clear()
                etIN.text?.clear()
                etWeight.text?.clear()
                tilFT.visibility = GONE
                tilIN.visibility = GONE
                tilHeight.visibility = VISIBLE
            }
            if (binding.etWeight.text!!.isNotEmpty() && binding.etHeight.text!!.isNotEmpty()){
                if (binding.chipMetrico.isChecked){
                    realiseOperation()
                }
            }
        }
        binding.chipImperial.setOnClickListener {
            binding.apply {
                chipMetrico.isChecked = false
                etHeight.text?.clear()
                etWeight.text?.clear()
                tilHeight.visibility = GONE
                tilFT.visibility = VISIBLE
                tilIN.visibility = VISIBLE
            }
            if (binding.etIN.text!!.isNotEmpty() && binding.etFT.text!!.isNotEmpty() && binding.etHeight.text!!.isNotEmpty()){
                if (binding.chipImperial.isChecked){
                    realiseOperation()
                }
            }
        }
    }

    private fun realiseOperation() {
        if (binding.chipMetrico.isChecked){
            if (validFieldsMetric()){
                val imc = IMC()
                val level = NivelIMC()
                val formatRes = FormatResults()
                val height = binding.etHeight.text.toString().toDouble()
                val weight = binding.etWeight.text.toString().toDouble()
                if (binding.chipMetrico.isChecked){
                    binding.chipImperial.isChecked = false
                    val result = imc.imcMetrico(height, weight)
                    val levelIMC = level.imcLevel(result)
                    val format = formatRes.twoDecimals(result)
                    binding.etResult.text = format.editable()
                    binding.tvResult.text = levelIMC.trim()
                }
            }
        } else if (binding.chipImperial.isChecked) {
            if (validFieldsImperial()){
                val imc = IMC()
                val level = NivelIMC()
                val formatRes = FormatResults()
                val ft = binding.etFT.text.toString().toDouble()
                val In = binding.etIN.text.toString().toDouble()
                val weight = binding.etWeight.text.toString().toDouble()
                if (binding.chipMetrico.isChecked){
                    binding.chipImperial.isChecked = false
                    val result = imc.imcImperial(ft, In, weight)
                    val levelIMC = level.imcLevel(result)
                    val format = formatRes.twoDecimals(result)
                    binding.etResult.text = format.editable()
                    binding.tvResult.text = levelIMC.trim()
                }
            }
        }
    }

    private fun validFieldsMetric(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etHeight.text.isNullOrEmpty()){
            binding.tilHeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilHeight.error = null
        }
        //  Evaluando value A
        if (binding.etWeight.text.isNullOrEmpty()){
            binding.tilWeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilWeight.error = null
        }
        return isValid
    }

    private fun validFieldsImperial(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etFT.text.isNullOrEmpty()){
            binding.tilFT.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilFT.error = null
        }
        //  Evaluando value A
        if (binding.etIN.text.isNullOrEmpty()){
            binding.tilIN.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilIN.error = null
        }
        //  Evaluando value A
        if (binding.etWeight.text.isNullOrEmpty()){
            binding.tilWeight.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilWeight.error = null
        }
        return isValid
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}