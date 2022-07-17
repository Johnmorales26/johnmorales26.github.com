package com.johndev.smartcalculator.usecases.fragments.BottomSheetOptions

import android.app.Dialog
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.FragmentBottomOptionsBinding
import com.johndev.smartcalculator.databinding.FragmentBottomVisibleOptionsBinding
import com.johndev.smartcalculator.usecases.Adapters.BottomOptionsAdapter
import com.johndev.smartcalculator.usecases.Adapters.BottomVisibleOptionsAdapter
import com.johndev.smartcalculator.usecases.Interfaces.OnBottomOptions
import com.johndev.smartcalculator.usecases.common.BottomOptions
import com.johndev.smartcalculator.usecases.common.ConversionsData

class BottomVisibleOptionsFragment(private val onSubmitClickListener: (MutableList<ConversionsData>) -> Unit, private var data: MutableList<ConversionsData>): BottomSheetDialogFragment(),
    OnBottomOptions {

    private var binding: FragmentBottomVisibleOptionsBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var adapter: BottomVisibleOptionsAdapter
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentBottomVisibleOptionsBinding.inflate(LayoutInflater.from(activity))
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        binding?.let {
            configureTheme()
            val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
            bottomSheetDialog.setContentView(it.root)
            bottomSheetBehavior = BottomSheetBehavior.from(it.root.parent as View)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            val recoveryData: Bundle? = arguments
            binding!!.tvTitle.text = getString(R.string.bottom_shet_add_options)
            setupRecyclerView()
            configureButton()
            binding!!.btnClose.setOnClickListener { dismiss() }
            return bottomSheetDialog
        }
        return super.onCreateDialog(savedInstanceState)
    }

    private fun configureButton() {

        var sendData: MutableList<ConversionsData> = mutableListOf()

        binding?.let {
            it.efab.setOnClickListener {
                data.forEach {
                    if (it.visibility){
                        sendData.add(it)
                    } else {
                        sendData.remove(it)
                    }
                }
                onSubmitClickListener.invoke(sendData)
                dismiss()
            }
        }
    }

    private fun configureTheme() {
        val theme = sharedPreferences.getString(getString(R.string.key_preference_application_color),
            getString(R.string.preference_key_color_default))
        when(theme) {
            getString(R.string.preference_key_color_default) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_red) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryRedColor)))
            }
            getString(R.string.preference_key_color_yellow) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryYellowColor)))
            }
            getString(R.string.preference_key_color_blue) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryBlueColor)))
            }
            getString(R.string.preference_key_color_green) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryGreenColor)))
            }
            getString(R.string.preference_key_color_purple) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryPurpleColor)))
            }
            getString(R.string.preference_key_color_orange) -> {
                binding?.appbar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(ColorsExtra.primaryOrangeColor)))
            }
        }
    }

    private fun setupRecyclerView() {
        binding?.let {
            adapter = BottomVisibleOptionsAdapter(data, this)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@BottomVisibleOptionsFragment.adapter
            }
        }
    }

    override fun onClick(bottomOptions: BottomOptions) {
        //onSubmitClickListener.invoke(bottomOptions)
        //dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}