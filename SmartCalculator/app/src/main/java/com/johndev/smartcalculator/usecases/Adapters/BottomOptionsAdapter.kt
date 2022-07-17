package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemBottomOptionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnBottomOptions
import com.johndev.smartcalculator.usecases.common.BottomOptions

class BottomOptionsAdapter(private val optionsList: MutableList<BottomOptions>, private val listener: OnBottomOptions)
    : RecyclerView.Adapter<BottomOptionsAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_bottom_options, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val option = optionsList[position]
        holder.setListener(option)
        with(holder){
            binding.apply {
                tvIcon.text = option.icon.trim()
                tvName.text = option.name.trim()

                val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                    context.getString(R.string.preference_key_color_default))
                when(theme) {
                    context.getString(R.string.preference_key_color_default) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryColor)
                    }
                    context.getString(R.string.preference_key_color_red) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryRedColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryRedColor)
                    }
                    context.getString(R.string.preference_key_color_yellow) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryYellowColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryYellowColor)
                    }
                    context.getString(R.string.preference_key_color_blue) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryBlueColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryBlueColor)
                    }
                    context.getString(R.string.preference_key_color_green) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryGreenColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryGreenColor)
                    }
                    context.getString(R.string.preference_key_color_purple) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryPurpleColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryPurpleColor)
                    }
                    context.getString(R.string.preference_key_color_orange) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryOrangeColor))
                        binding.cvContainer.strokeColor = context.getColor(R.color.primaryOrangeColor)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = optionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemBottomOptionsBinding.bind(view)

        fun setListener(bottomOptions: BottomOptions){
            binding.root.setOnClickListener {
                listener.onClick(bottomOptions)
                true
            }
        }
    }

}