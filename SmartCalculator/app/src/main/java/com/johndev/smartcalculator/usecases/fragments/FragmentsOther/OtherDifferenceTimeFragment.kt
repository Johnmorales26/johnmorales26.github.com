package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import Time.Horas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOtherAddDateBinding
import com.johndev.smartcalculator.databinding.FragmentOtherDifferenceTimeBinding
import com.johndev.smartcalculator.usecases.common.Conections
import com.johndev.smartcalculator.usecases.common.Conections.Companion.differenceTime

class OtherDifferenceTimeFragment : Fragment() {

    private var _binding: FragmentOtherDifferenceTimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherDifferenceTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configButtons()
    }

    private fun configButtons() {
        binding.btnResult.setOnClickListener {
            if (validFields()){
                val startHour = binding.etStartHour.text.toString().trim()
                val startMinute = binding.etStartMinute.text.toString().trim()
                val startSecond = binding.etStartSecond.text.toString().trim()
                val endHour = binding.etEndHour.text.toString().trim()
                val endMinute = binding.etEndMinute.text.toString().trim()
                val endSecond = binding.etEndSecond.text.toString().trim()
                var horaOne = "$startHour:$startMinute:$startSecond"
                var horaTwo = "$endHour:$endMinute:$endSecond"
                binding.tvResult.text = formatHour(differenceTime.calculate(horaOne, horaTwo))
            }
        }
    }

    private fun formatHour(hour: Horas): String{
        val dias = hour.day
        val horas = hour.hora
        val minutos = hour.minuto
        val segundo = hour.seconds
        val zone = hour.dia
        return "Hours: $horas, Minutes: $minutos, Seconds: $segundo"
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etStartHour.text.isNullOrEmpty()){
            binding.tilStartHour.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilStartHour.error = null
        }
        //  Evaluando value B
        if (binding.etStartMinute.text.isNullOrEmpty()){
            binding.tilStartMinute.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilStartMinute.error = null
        }
        //  Evaluando value A
        if (binding.etStartSecond.text.isNullOrEmpty()){
            binding.tilStartSecond.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilStartSecond.error = null
        }
        //  Evaluando value B
        if (binding.etEndHour.text.isNullOrEmpty()){
            binding.tilEndHour.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilEndHour.error = null
        }
        //  Evaluando value B
        if (binding.etEndMinute.text.isNullOrEmpty()){
            binding.tilEndMinute.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilEndMinute.error = null
        }
        //  Evaluando value B
        if (binding.etEndSecond.text.isNullOrEmpty()){
            binding.tilEndSecond.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilEndSecond.error = null
        }
        return isValid
    }

}