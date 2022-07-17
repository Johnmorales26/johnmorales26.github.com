package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOtherDifferenceDateBinding
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import kotlin.math.abs


class OtherDifferenceDateFragment : Fragment() {

    private var _binding: FragmentOtherDifferenceDateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherDifferenceDateBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnResult.setOnClickListener {
            if (validFields()){
                val startDay = binding.etStartDay.text.toString().trim().toInt()
                val startMonth = monthToNuumber(binding.btnOpMontStart.text.toString().trim())
                val startYear = binding.etStartYear.text.toString().trim().toInt()
                val endDay = binding.etEndDay.text.toString().trim().toInt()
                val endMonth = monthToNuumber(binding.btnOpMontEnd.text.toString().trim())
                val endYear = binding.etEndYear.text.toString().trim().toInt()

                val startDate: LocalDate = LocalDate.parse("$startYear-$startMonth-$startDay", DateTimeFormatter.ISO_LOCAL_DATE)
                val endDate: LocalDate = LocalDate.parse("$endYear-$endMonth-$endDay", DateTimeFormatter.ISO_LOCAL_DATE)

                val period: Period = Period.between(startDate, endDate)

                val years = abs(period.years)
                val months = abs(period.months)
                val days = abs(period.days)

                val result = "$days / $months / $years"
                binding.tvResult.text = result.toString().trim()
            }
        }
    }

    fun monthToNuumber(month: String): Int{
        return when(month) {
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
            binding.etStartYear.error = null
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
        if (binding.etEndDay.text.isNullOrEmpty()){
            binding.tilEndDay.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilEndDay.error = null
        }
        //  Evaluando value B
        if (binding.etEndYear.text.isNullOrEmpty()){
            binding.tilEndYear.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilEndYear.error = null
        }
        return isValid
    }
}