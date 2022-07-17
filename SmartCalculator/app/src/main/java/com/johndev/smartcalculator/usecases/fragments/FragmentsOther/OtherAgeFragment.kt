package com.johndev.smartcalculator.usecases.fragments.FragmentsOther

import Birthday.Age
import Birthday.MyTypeDate
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentOtherAgeBinding
import com.johndev.smartcalculator.databinding.FragmentOtherBodyMassBinding
import com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions.BottomOptionsFragment
import java.time.LocalDate
import java.time.Period

class OtherAgeFragment : Fragment() {

    private var _binding: FragmentOtherAgeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherAgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configButtons()
        calculateResult()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateResult() {
        binding.btnResult.setOnClickListener {
            if (validFields()){
                val bornMonth = asignMonth(binding.btnMonthBorn.text.toString().trim())
                val currentMonth = asignMonth(binding.btnMonthCurrent.text.toString().trim())
                val bornDay = binding.etDayBorn.text.toString().trim().toInt()
                val currentDay = binding.etDayCurrent.text.toString().trim().toInt()
                val bornYear = binding.etYearBorn.text.toString().trim().toInt()
                val currentYear = binding.etYearCurrent.text.toString().trim().toInt()

                val edad = Period.between(LocalDate.of(bornYear, bornMonth, bornDay), LocalDate.of(currentYear, currentMonth, currentDay))
                val formatEdad = getString(R.string.other_age_result, edad.years, edad.months, edad.days)

                val next = Period.between(LocalDate.of(currentYear, currentMonth, currentDay), LocalDate.of(currentYear, bornMonth, bornDay))
                binding.tvAgeResult.text = formatEdad
                binding.tvNextResult.text = getString(R.string.other_age_result, next.years, next.months, next.days)
            }
        }
    }

    private fun asignMonth(month: String): Int {
        return when(month){
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
            else -> 12
        }
    }

    private fun asignMonth(month: Int): String {
        return when(month){
            1 -> getString(R.string.month_year_january)
            2 -> getString(R.string.month_year_february)
            3 -> getString(R.string.month_year_march)
            4 -> getString(R.string.month_year_april)
            5 -> getString(R.string.month_year_may)
            6 -> getString(R.string.month_year_june)
            7 -> getString(R.string.month_year_july)
            8 -> getString(R.string.month_year_august)
            9 -> getString(R.string.month_year_september)
            10 -> getString(R.string.month_year_october)
            11 -> getString(R.string.month_year_november)
            else -> getString(R.string.month_year_dicember)
        }
    }

    private fun configButtons() {
        binding.btnMonthBorn.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnMonthBorn.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.month_year_january))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
        binding.btnMonthCurrent.setOnClickListener {
            val fragment = BottomOptionsFragment(
                onSubmitClickListener = { data ->
                    binding.btnMonthCurrent.text = data.name.trim()
                }
            )
            val sendData = Bundle()
            sendData.putString("option", getString(R.string.month_year_january))
            fragment.arguments = sendData
            fragmentManager?.let { it1 -> fragment.show(it1.beginTransaction(), BottomOptionsFragment::class.java.simpleName) }
        }
    }

    private fun validFields(): Boolean{
        var isValid = true
        //  Evaluando value A
        if (binding.etDayBorn.text.isNullOrEmpty()){
            binding.tilDayBorn.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilDayBorn.error = null
        }
        //  Evaluando value B
        if (binding.etYearBorn.text.isNullOrEmpty()){
            binding.tilYearBorn.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilYearBorn.error = null
        }
        //  Evaluando value C
        if (binding.etDayCurrent.text.isNullOrEmpty()){
            binding.tilDayCurrent.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilDayCurrent.error = null
        }
        //  Evaluando value C
        if (binding.etYearCurrent.text.isNullOrEmpty()){
            binding.tilYearCurrent.run {
                error = getString(R.string.alert_required)
                requestFocus()
            }
            isValid = false
        } else {
            binding.tilYearCurrent.error = null
        }
        return isValid
    }

}