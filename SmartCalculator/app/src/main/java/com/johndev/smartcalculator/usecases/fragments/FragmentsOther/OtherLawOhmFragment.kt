package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import OhmLaw.Intensidad.OhmIntensidad
import OhmLaw.Potencia.OhmPotencia
import OhmLaw.Resistencia.OhmResistencia
import OhmLaw.ResourcesOhm.DataTransform
import OhmLaw.ResourcesOhm.TypeData
import OhmLaw.Tension.OhmTension
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOtherLawOhmBinding
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment

class OtherLawOhmFragment : Fragment() {

    private var _binding: FragmentOtherLawOhmBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherLawOhmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configOptionsButtons()
    }

    private fun configOptionsButtons() {
        binding.btnOptionsVoltaje.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.tvOptionVoltaje.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.other_law_voltaje))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
        binding.btnOptionsCorriente.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.tvOptionCorriente.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.other_law_corriente))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
        binding.btnOptionsResistencia.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.tvOptionResistencia.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.other_law_resistencia))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
        binding.btnOptionsPotencia.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.tvOptionPotencia.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.other_law_potencia))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
        binding.btnClear.setOnClickListener {
            binding.apply {
                etVoltaje.text = "".editable()
                etCorriente.text = "".editable()
                etPotencia.text = "".editable()
                etResistencia.text = "".editable()
            }
        }
        binding.btnResult.setOnClickListener { selectedOperation() }
    }

    private fun selectedOperation() {
        val potencia = OhmPotencia()
        val corriente = OhmIntensidad()
        val resistencia = OhmResistencia()
        val voltaje = OhmTension()
        when {
            binding.etVoltaje.text?.isEmpty() == false && binding.etCorriente.text?.isEmpty() == false -> {
                // potencia & resistencia
                val typeVoltaje = binding.tvOptionVoltaje.text
                val typeCorriente = binding.tvOptionCorriente.text
                val valueVoltaje = binding.etVoltaje.text.toString().toDouble()
                val valueCorriente = binding.etCorriente.text.toString().toDouble()
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typeCorriente == getString(R.string.bottom_option_amperio)){
                    val rResistencia = resistencia.resistenciaVI(valueVoltaje, valueCorriente, TypeData.VOLTIO, TypeData.AMPERIO)
                    val rPotencia = potencia.potenciaVI(valueVoltaje, valueCorriente, TypeData.VOLTIO, TypeData.AMPERIO)
                    variationOperationOne(rResistencia, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typeCorriente == getString(R.string.bottom_option_milliamperios)){
                    val rResistencia = resistencia.resistenciaVI(valueVoltaje, valueCorriente, TypeData.VOLTIO, TypeData.MILIAMPERIOS)
                    val rPotencia = potencia.potenciaVI(valueVoltaje, valueCorriente, TypeData.VOLTIO, TypeData.MILIAMPERIOS)
                    variationOperationOne(rResistencia, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_millivoltio) && typeCorriente == getString(R.string.bottom_option_amperio)){
                    val rResistencia = resistencia.resistenciaVI(valueVoltaje, valueCorriente, TypeData.MILIVOLTIO, TypeData.AMPERIO)
                    val rPotencia = potencia.potenciaVI(valueVoltaje, valueCorriente, TypeData.MILIVOLTIO, TypeData.AMPERIO)
                    variationOperationOne(rResistencia, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_milivatios) && typeCorriente == getString(R.string.bottom_option_milliamperios)){
                    val rResistencia = resistencia.resistenciaVI(valueVoltaje, valueCorriente, TypeData.MILIVOLTIO, TypeData.MILIAMPERIOS)
                    val rPotencia = potencia.potenciaVI(valueVoltaje, valueCorriente, TypeData.MILIVOLTIO, TypeData.MILIAMPERIOS)
                    variationOperationOne(rResistencia, rPotencia)
                }
            }
            binding.etVoltaje.text?.isEmpty() == false && binding.etResistencia.text?.isEmpty() == false -> {
                val typeVoltaje = binding.tvOptionVoltaje.text
                val typeResistencia = binding.tvOptionResistencia.text
                val valueVoltaje = binding.etVoltaje.text.toString().toDouble()
                val valueResistencia = binding.etResistencia.text.toString().toDouble()
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typeResistencia == getString(R.string.bottom_option_ohm)){
                    val rCorriente = corriente.intensidadVR(valueVoltaje, valueResistencia, TypeData.VOLTIO, TypeData.OHM)
                    val rPotencia = potencia.potenciaVR(valueVoltaje, valueResistencia, TypeData.VOLTIO, TypeData.OHM)
                    variationOperationTwo(rCorriente, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typeResistencia == getString(R.string.bottom_option_milliohm)){
                    val rCorriente = corriente.intensidadVR(valueVoltaje, valueResistencia, TypeData.VOLTIO, TypeData.MILLIOHM)
                    val rPotencia = potencia.potenciaVR(valueVoltaje, valueResistencia, TypeData.VOLTIO, TypeData.MILLIOHM)
                    variationOperationTwo(rCorriente, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_millivoltio) && typeResistencia == getString(R.string.bottom_option_ohm)){
                    val rCorriente = corriente.intensidadVR(valueVoltaje, valueResistencia, TypeData.MILIVOLTIO, TypeData.OHM)
                    val rPotencia = potencia.potenciaVR(valueVoltaje, valueResistencia, TypeData.MILIVOLTIO, TypeData.OHM)
                    variationOperationTwo(rCorriente, rPotencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_milivatios) && typeResistencia == getString(R.string.bottom_option_milliohm)){
                    val rCorriente = corriente.intensidadVR(valueVoltaje, valueResistencia, TypeData.MILIVOLTIO, TypeData.MILLIOHM)
                    val rPotencia = potencia.potenciaVR(valueVoltaje, valueResistencia, TypeData.MILIVOLTIO, TypeData.MILLIOHM)
                    variationOperationTwo(rCorriente, rPotencia)
                }
            }
            binding.etVoltaje.text?.isEmpty() == false && binding.etPotencia.text?.isEmpty() == false -> {
                val typeVoltaje = binding.tvOptionVoltaje.text
                val typePotencia = binding.tvOptionPotencia.text
                val valueVoltaje = binding.etVoltaje.text.toString().toDouble()
                val valuePotencia = binding.etPotencia.text.toString().toDouble()
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.WATIO)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.WATIO)
                    variationOperationThree(rCorriente, rResistencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.MILIVATIOS)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.MILIVATIOS)
                    variationOperationThree(rCorriente, rResistencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_voltio) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.KILOVATIO)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.VOLTIO, TypeData.KILOVATIO)
                    variationOperationThree(rCorriente, rResistencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_millivoltio) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.WATIO)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.WATIO)
                    variationOperationThree(rCorriente, rResistencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_milivatios) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.MILIVATIOS)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.MILIVATIOS)
                    variationOperationThree(rCorriente, rResistencia)
                }
                if (typeVoltaje == getString(R.string.bottom_option_milivatios) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rCorriente = corriente.intensidadPV(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.KILOVATIO)
                    val rResistencia = resistencia.resistenciaVP(valueVoltaje, valuePotencia, TypeData.MILIVOLTIO, TypeData.KILOVATIO)
                    variationOperationThree(rCorriente, rResistencia)
                }
            }
            binding.etCorriente.text?.isEmpty() == false && binding.etResistencia.text?.isEmpty() == false -> {
                val typeResistencia = binding.tvOptionResistencia.text
                val typeCorriente = binding.tvOptionCorriente.text
                val valueResistencia = binding.etResistencia.text.toString().toDouble()
                val valueCorriente = binding.etCorriente.text.toString().toDouble()
                if (typeResistencia == getString(R.string.bottom_option_ohm) && typeCorriente == getString(R.string.bottom_option_amperio)){
                    val rVoltaje = voltaje.tensionRI(valueResistencia, valueCorriente, TypeData.OHM, TypeData.AMPERIO)
                    val rPotencia = potencia.potenciaRI(valueResistencia, valueCorriente, TypeData.OHM, TypeData.AMPERIO)
                    variationOperationFour(rVoltaje, rPotencia)
                }
                if (typeResistencia == getString(R.string.bottom_option_ohm) && typeCorriente == getString(R.string.bottom_option_milliamperios)){
                    val rVoltaje = voltaje.tensionRI(valueResistencia, valueCorriente, TypeData.OHM, TypeData.MILIAMPERIOS)
                    val rPotencia = potencia.potenciaRI(valueResistencia, valueCorriente, TypeData.OHM, TypeData.MILIAMPERIOS)
                    variationOperationFour(rVoltaje, rPotencia)
                }
                if (typeResistencia == getString(R.string.bottom_option_milliohm) && typeCorriente == getString(R.string.bottom_option_amperio)){
                    val rVoltaje = voltaje.tensionRI(valueResistencia, valueCorriente, TypeData.MILLIOHM, TypeData.AMPERIO)
                    val rPotencia = potencia.potenciaRI(valueResistencia, valueCorriente, TypeData.MILLIOHM, TypeData.AMPERIO)
                    variationOperationFour(rVoltaje, rPotencia)
                }
                if (typeResistencia == getString(R.string.bottom_option_milivatios) && typeCorriente == getString(R.string.bottom_option_milliamperios)){
                    val rVoltaje = voltaje.tensionRI(valueResistencia, valueCorriente, TypeData.MILLIOHM, TypeData.MILIAMPERIOS)
                    val rPotencia = potencia.potenciaRI(valueResistencia, valueCorriente, TypeData.MILLIOHM, TypeData.MILIAMPERIOS)
                    variationOperationFour(rVoltaje, rPotencia)
                }
            }
            binding.etCorriente.text?.isEmpty() == false && binding.etPotencia.text?.isEmpty() == false -> {
                val typeCorriente = binding.tvOptionCorriente.text
                val typePotencia = binding.tvOptionPotencia.text
                val valueCorriente = binding.etCorriente.text.toString().toDouble()
                val valuePotencia = binding.etPotencia.text.toString().toDouble()
                if (typeCorriente == getString(R.string.bottom_option_amperio) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.WATIO, TypeData.AMPERIO)
                    val rResistencia = resistencia.resistenciaPI(valueCorriente, valuePotencia, TypeData.AMPERIO, TypeData.WATIO)
                    variationOperationFive(rVoltaje, rResistencia)
                }
                if (typeCorriente == getString(R.string.bottom_option_amperio) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.MILIVATIOS, TypeData.AMPERIO)
                    val rResistencia = resistencia.resistenciaVP(valueCorriente, valuePotencia, TypeData.AMPERIO, TypeData.MILIVATIOS)
                    variationOperationFive(rVoltaje, rResistencia)
                }
                if (typeCorriente == getString(R.string.bottom_option_amperio) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.KILOVATIO, TypeData.AMPERIO)
                    val rResistencia = resistencia.resistenciaVP(valueCorriente, valuePotencia, TypeData.AMPERIO, TypeData.KILOVATIO)
                    variationOperationFive(rVoltaje, rResistencia)
                }
                if (typeCorriente == getString(R.string.bottom_option_milliamperios) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.WATIO, TypeData.MILIAMPERIOS)
                    val rResistencia = resistencia.resistenciaVP(valueCorriente, valuePotencia, TypeData.MILIAMPERIOS, TypeData.WATIO)
                    variationOperationFive(rVoltaje, rResistencia)
                }
                if (typeCorriente == getString(R.string.bottom_option_milliamperios) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.MILIVATIOS, TypeData.MILIAMPERIOS)
                    val rResistencia = resistencia.resistenciaVP(valueCorriente, valuePotencia, TypeData.MILIAMPERIOS, TypeData.MILIVATIOS)
                    variationOperationFive(rVoltaje, rResistencia)
                }
                if (typeCorriente == getString(R.string.bottom_option_milliamperios) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rVoltaje = voltaje.tensionPI(valuePotencia, valueCorriente,  TypeData.KILOVATIO, TypeData.MILIAMPERIOS)
                    val rResistencia = resistencia.resistenciaVP(valueCorriente, valuePotencia, TypeData.MILIAMPERIOS, TypeData.KILOVATIO)
                    variationOperationFive(rVoltaje, rResistencia)
                }
            }
            binding.etResistencia.text?.isEmpty() == false && binding.etPotencia.text?.isEmpty() == false -> {
                val typeResistencia = binding.tvOptionResistencia.text
                val typePotencia = binding.tvOptionPotencia.text
                val valueResistencia = binding.etResistencia.text.toString().toDouble()
                val valuePotencia = binding.etPotencia.text.toString().toDouble()
                if (typeResistencia == getString(R.string.bottom_option_ohm) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rVoltaje = voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.WATIO, TypeData.OHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.WATIO, TypeData.OHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
                if (typeResistencia == getString(R.string.bottom_option_ohm) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rVoltaje =voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.MILIVATIOS, TypeData.OHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.MILIVATIOS, TypeData.OHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
                if (typeResistencia == getString(R.string.bottom_option_ohm) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rVoltaje = voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.KILOVATIO, TypeData.OHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.KILOVATIO, TypeData.OHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
                if (typeResistencia == getString(R.string.bottom_option_milliohm) && typePotencia == getString(R.string.bottom_option_watio)){
                    val rVoltaje = voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.WATIO, TypeData.MILLIOHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.WATIO, TypeData.MILLIOHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
                if (typeResistencia == getString(R.string.bottom_option_milliohm) && typePotencia == getString(R.string.bottom_option_milivatios)){
                    val rVoltaje = voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.MILIVATIOS, TypeData.MILLIOHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.MILIVATIOS, TypeData.MILLIOHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
                if (typeResistencia == getString(R.string.bottom_option_milliohm) && typePotencia == getString(R.string.bottom_option_kilowatio)){
                    val rVoltaje = voltaje.tensionPR(valuePotencia, valueResistencia,  TypeData.KILOVATIO, TypeData.MILLIOHM)
                    val rCorriente = corriente.intensidadPR(valuePotencia, valueResistencia,  TypeData.KILOVATIO, TypeData.MILLIOHM)
                    variationOperationSix(rVoltaje, rCorriente)
                }
            }
        }
    }

    private fun variationOperationSix(rVoltaje: Double, rCorriente: Double) {
        val transform = DataTransform()
        when (binding.tvOptionCorriente.text) {
            getString(R.string.bottom_option_amperio) -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.AMPERIO).editable()
            }
            else -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.MILIAMPERIOS).editable()
            }
        }
        when (binding.tvOptionVoltaje.text) {
            getString(R.string.bottom_option_voltio) -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.VOLTIO).editable()
            }
            else -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.MILIVOLTIO).editable()
            }
        }
    }

    private fun variationOperationFive(rVoltaje: Double, rResistencia: Double) {
        val transform = DataTransform()
        when (binding.tvOptionVoltaje.text) {
            getString(R.string.bottom_option_voltio) -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.VOLTIO).editable()
            }
            else -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.MILIVOLTIO).editable()
            }
        }
        when (binding.tvOptionResistencia.text) {
            getString(R.string.bottom_option_ohm) -> {
                binding.etResistencia.text = transform.resistenciaTo(rResistencia, TypeData.OHM).editable()
            }
            else -> {
                binding.etResistencia.text = transform.resistenciaTo(rResistencia, TypeData.MILLIOHM).editable()
            }
        }
    }

    private fun variationOperationFour(rVoltaje: Double, rPotencia: Double) {
        val transform = DataTransform()
        when (binding.tvOptionVoltaje.text) {
            getString(R.string.bottom_option_voltio) -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.VOLTIO).editable()
            }
            else -> {
                binding.etVoltaje.text =
                    transform.voltsTo(rVoltaje, TypeData.MILIVOLTIO).editable()
            }
        }
        when (binding.tvOptionPotencia.text) {
            getString(R.string.bottom_option_watio) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.WATIO).editable()
            }
            getString(R.string.bottom_option_milivatios) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.MILIVATIOS).editable()
            }
            else -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.KILOVATIO).editable()
            }
        }
    }

    private fun variationOperationThree(rCorriente: Double, rResistencia: Double) {
        val transform = DataTransform()
        when (binding.tvOptionCorriente.text) {
            getString(R.string.bottom_option_amperio) -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.AMPERIO).editable()
            }
            else -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.MILIAMPERIOS).editable()
            }
        }
        when (binding.tvOptionResistencia.text) {
            getString(R.string.bottom_option_ohm) -> {
                binding.etResistencia.text = transform.resistenciaTo(rResistencia, TypeData.OHM).editable()
            }
            else -> {
                binding.etResistencia.text = transform.resistenciaTo(rResistencia, TypeData.MILLIOHM).editable()
            }
        }
    }

    private fun variationOperationTwo(rCorriente: Double, rPotencia: Double) {
        val transform = DataTransform()
        when (binding.tvOptionCorriente.text) {
            getString(R.string.bottom_option_amperio) -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.AMPERIO).editable()
            }
            else -> {
                binding.etCorriente.text =
                    transform.corrienteTo(rCorriente, TypeData.MILIAMPERIOS).editable()
            }
        }
        when (binding.tvOptionPotencia.text) {
            getString(R.string.bottom_option_watio) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.WATIO).editable()
            }
            getString(R.string.bottom_option_milivatios) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.MILIVATIOS).editable()
            }
            else -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.KILOVATIO).editable()
            }
        }
    }

    private fun variationOperationOne(rResistencia: Double, rPotencia: Double) {
        val transform = DataTransform()
        when (binding.tvOptionResistencia.text) {
            getString(R.string.bottom_option_ohm) -> {
                binding.etResistencia.text =
                    transform.resistenciaTo(rResistencia, TypeData.OHM).editable()
            }
            else -> {
                binding.etResistencia.text =
                    transform.resistenciaTo(rResistencia, TypeData.MILLIOHM).editable()
            }
        }
        when (binding.tvOptionPotencia.text) {
            getString(R.string.bottom_option_watio) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.WATIO).editable()
            }
            getString(R.string.bottom_option_milivatios) -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.MILIVATIOS).editable()
            }
            else -> {
                binding.etPotencia.text = transform.potenciaTo(rPotencia, TypeData.KILOVATIO).editable()
            }
        }
    }


    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

}