package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import Time.Horas
import Time.HourDay
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOtherAddTimeBinding
import com.johndev.smartcalculator.usecases.common.Conections.Companion.addSubTime
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment

class OtherAddTimeFragment : Fragment() {

    private var _binding: FragmentOtherAddTimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherAddTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configButtons()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun configButtons() {

        binding.btnTime.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnTime.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.hint_value_am))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName)
            }
        }

        binding.btnOptionOp.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnOptionOp.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.tv_sum))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName)
            }
        }

        binding.btnResult.setOnClickListener {
            if (validFields()){
                val startHour = binding.etStartHour.text.toString().toInt()
                val startMinute = binding.etStartMinute.text.toString().toInt()
                val tipeDay = binding.btnOptionOp.text.toString().trim()
                val sumHour = binding.etHourOp.text.toString().toInt()
                val sumMinute = binding.etMinuteOp.text.toString().toInt()
                var firtsHour: Horas = if (tipeDay == getString(R.string.hint_value_am)){
                    Horas(hora = startHour, minuto = startMinute, dia = HourDay.AM)
                } else {
                    Horas(hora = startHour, minuto = startMinute, dia = HourDay.PM)
                }
                val secondHour = Horas(hora = sumHour, minuto = sumMinute)
                when(binding.btnOptionOp.text){
                    getString(R.string.tv_sum) -> {
                        //Horas(val day: Int = 0,val hora: Int, val minuto: Int, val seconds: Int = 0, val dia: HourDay = HourDay.AM)
                        binding.tvResult.text = formatHour(addSubTime.addHours(firtsHour, secondHour))
                    }
                    getString(R.string.tv_subtration) -> {
                        binding.tvResult.text = formatHour(addSubTime.subtractHour(firtsHour, secondHour))
                    }
                }
            }
        }
    }

    private fun formatHour(hour: Horas): String{
        val dias = hour.day
        val horas = hour.hora
        val minutos = hour.minuto
        val segundo = hour.seconds
        val zone = hour.dia
        return "Hours: $horas, Minutes: $minutos, Hour: $zone"
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etHourOp.text.isNullOrEmpty()){
            binding.tilHourOp.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilHourOp.error = null
        }
        //  Evaluando value B
        if (binding.etMinuteOp.text.isNullOrEmpty()){
            binding.tilMinuteOp.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilMinuteOp.error = null
        }
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
        return isValid
    }

}

