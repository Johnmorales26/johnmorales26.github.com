package com.johndev.smartcalculator.usecases.fragments.Dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.SharedPreferences
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.preference.PreferenceManager
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.DialogNextUpdateBinding

class NextUpdateDialog: DialogFragment() {

    private lateinit var binding: DialogNextUpdateBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogNextUpdateBinding.inflate(LayoutInflater.from(context))
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context!!)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnNext.setOnClickListener { dismiss() }
        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setupTheme()
        return dialog
    }

    private fun setupTheme() {
        //--------------------------------------------
        val theme = sharedPreferences.getString(context?.getString(R.string.key_preference_application_color),
            context?.getString(R.string.preference_key_color_default))
        when(theme) {
            context?.getString(R.string.preference_key_color_default) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryColor)!!
            }
            context?.getString(R.string.preference_key_color_red) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryRedColor)!!
            }
            context?.getString(R.string.preference_key_color_yellow) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryYellowColor)!!
            }
            context?.getString(R.string.preference_key_color_blue) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryBlueColor)!!
            }
            context?.getString(R.string.preference_key_color_green) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryGreenColor)!!
            }
            context?.getString(R.string.preference_key_color_purple) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryPurpleColor)!!
            }
            context?.getString(R.string.preference_key_color_orange) -> {
                binding.cardView.strokeColor = context?.getColor(R.color.primaryOrangeColor)!!
            }
        }
    }

}