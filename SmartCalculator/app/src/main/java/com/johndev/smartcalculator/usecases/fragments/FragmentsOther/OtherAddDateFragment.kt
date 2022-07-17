package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentConversionAngleBinding
import com.johndev.smartcalculator.databinding.FragmentOtherAddDateBinding
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import java.util.*

class OtherAddDateFragment : Fragment() {

    private var _binding: FragmentOtherAddDateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherAddDateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configButtonOptions()
    }

    private fun configButtonOptions() {

        binding.btnOptionOp.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnOptionOp.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.tv_sum))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }

        binding.btnMont.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnMont.text = data.icon.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.month_year_january))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }

        binding.btnResult.setOnClickListener {
            if (validFields()){
                val dayCurrent = binding.etStartDay.text.toString().trim().toInt()
                val yearCurrent = binding.etStartYear.text.toString().trim().toInt()
                val monthCurrent = when(binding.btnMont.text) {
                    getString(R.string.month_year_january) -> 1
                    getString(R.string.month_year_february) -> 2
                    getString(R.string.month_year_march) -> 3
                    getString(R.string.month_year_april) -> 4
                    getString(R.string.month_year_may) -> 5
                    getString(R.string.month_year_june) -> 6
                    getString(R.string.month_year_july) -> 7
                    getString(R.string.month_year_august) -> 8
                    getString(R.string.month_year_september) -> 9
                    getString(R.string.month_year_october) -> 10
                    getString(R.string.month_year_november) -> 11
                    getString(R.string.month_year_dicember) -> 12
                    else -> 1
                }
                val opDay = binding.etDayOp.text.toString().trim().toInt()
                val opMont = binding.etMonthOp.text.toString().trim().toInt()
                val opYear = binding.etYearOp.text.toString().trim().toInt()
                val dateCurrent = Date(yearCurrent, monthCurrent, dayCurrent)
                if (binding.btnOptionOp.text == getText(R.string.tv_sum)){
                    val calendar = sumDate(dateCurrent, opDay, opMont, opYear)
                    val date = "${calendar.time.day} / ${calendar.time.month} / ${calendar.time.year}"
                    binding.tvResult.text = date.trim()
                } else {
                    val calendar = restDate(dateCurrent, opDay, opMont, opYear)
                    val date = "${calendar.time.day} / ${calendar.time.month} / ${calendar.time.year}"
                    binding.tvResult.text = date.trim()
                }
            }
        }
    }

    private fun sumDate(fecha: Date, Dias: Int, Meses: Int, Years: Int): Calendar{
        val calendar = Calendar.getInstance()
        calendar.time = fecha
        calendar.apply {
            add(Calendar.DAY_OF_YEAR, Dias)
            add(Calendar.MONTH, Meses)
            add(Calendar.YEAR, Years)
        }
        return calendar
    }

    private fun restDate(fecha: Date, Dias: Int, Meses: Int, Years: Int): Calendar{
        val calendar = Calendar.getInstance()
        calendar.time = fecha
        calendar.apply {
            add(Calendar.DAY_OF_YEAR, Dias * -1)
            add(Calendar.MONTH, Meses * -1)
            add(Calendar.YEAR, Years * 1)
        }
        return calendar
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etStartDay.text.isNullOrEmpty()){
            binding.tilStartDay.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilStartDay.error = null
        }
        //  Evaluando value B
        if (binding.etStartYear.text.isNullOrEmpty()){
            binding.tilStartYear.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilStartYear.error = null
        }
        //  Evaluando value A
        if (binding.etDayOp.text.isNullOrEmpty()){
            binding.tilDayOp.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilDayOp.error = null
        }
        //  Evaluando value B
        if (binding.etMonthOp.text.isNullOrEmpty()){
            binding.tilMonthOp.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilMonthOp.error = null
        }
        //  Evaluando value B
        if (binding.etYearOp.text.isNullOrEmpty()){
            binding.tilYearOp.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilYearOp.error = null
        }
        return isValid
    }

}