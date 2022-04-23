package com.johndev.neurontraining.BottomOptions

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.neurontraining.Adapters.BottomOptionsAdapter
import com.johndev.neurontraining.Interfaces.OnBottomOptions
import com.johndev.neurontraining.R
import com.johndev.neurontraining.databinding.FragmentBottomOptionsBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomOptionsFragment(private val onSubmitClickListener: (BottomOptions) -> Unit): BottomSheetDialogFragment(),
    OnBottomOptions {

    private var binding: FragmentBottomOptionsBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var adapter: BottomOptionsAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentBottomOptionsBinding.inflate(LayoutInflater.from(activity))
        binding?.let {
            val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
            bottomSheetDialog.setContentView(it.root)
            bottomSheetBehavior = BottomSheetBehavior.from(it.root.parent as View)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            val recoveryData: Bundle? = arguments
            //binding!!.tvTitle.text = getString(R.string.bottom_shet_optons_title)
            setupRecyclerView(recoveryData?.getString("option"))
            binding!!.btnClose.setOnClickListener { dismiss() }
            return bottomSheetDialog
        }
        return super.onCreateDialog(savedInstanceState)
    }

    private fun setupRecyclerView(recovery: String?) {
        val options = inflateOptions(recovery)
        binding?.let {
            adapter = BottomOptionsAdapter(options, this)
            it.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@BottomOptionsFragment.adapter
            }
        }
    }

    private fun inflateOptions(recovery: String?): MutableList<BottomOptions> {
        return when(recovery){
            //  Ohm's Law Screen
            "More" -> {
                mutableListOf(
                    BottomOptions(1, 12, getString(R.string.bottom_options_view_graphics)),
                    BottomOptions(2, 12, getString(R.string.bottom_options_view_progress))
                )
            }
            else -> { mutableListOf() }
        }
    }

    override fun onClick(bottomOptions: BottomOptions) {
        onSubmitClickListener.invoke(bottomOptions)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}