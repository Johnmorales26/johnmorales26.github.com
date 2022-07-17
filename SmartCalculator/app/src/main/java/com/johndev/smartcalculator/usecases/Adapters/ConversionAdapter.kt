package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemConversionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnBottomOptions
import com.johndev.smartcalculator.usecases.Interfaces.OnConversionListener
import com.johndev.smartcalculator.usecases.common.ConversionsData
import com.johndev.smartcalculator.usecases.common.FunctionsGeometryBodies

class ConversionAdapter (private var optionsList: MutableList<ConversionsData>, private val listener: OnConversionListener)
    : RecyclerView.Adapter<ConversionAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversionAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_conversions, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ConversionAdapter.ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val format = FunctionsGeometryBodies(context)
        val option = optionsList[position]
        holder.setListener(option)
        with(holder){
            binding.apply {
                tvIcon.text = option.icon
                tvName.text = option.name
                tvResult.text = option.result.toString().trim()
                cardView.visibility = if (!option.visibility){
                    GONE
                } else {
                    VISIBLE
                }
                tvResult.text = (option.result).toString().trim()
                //--------------------------------------------
                val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                    context.getString(R.string.preference_key_color_default))
                when(theme) {
                    context.getString(R.string.preference_key_color_default) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryColor)
                    }
                    context.getString(R.string.preference_key_color_red) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryRedColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryRedColor)
                    }
                    context.getString(R.string.preference_key_color_yellow) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryYellowColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryYellowColor)
                    }
                    context.getString(R.string.preference_key_color_blue) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryBlueColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryBlueColor)
                    }
                    context.getString(R.string.preference_key_color_green) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryGreenColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryGreenColor)
                    }
                    context.getString(R.string.preference_key_color_purple) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryPurpleColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryPurpleColor)
                    }
                    context.getString(R.string.preference_key_color_orange) -> {
                        binding.tvIcon.setTextColor(context.getColor(R.color.primaryOrangeColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryOrangeColor)
                    }
                }
            }
        }
    }

    fun update(conversionData: ConversionsData){
        val index = optionsList.indexOf(conversionData)
        if (index != -1){
            optionsList[index] = conversionData
            notifyItemChanged(index)
        }
    }

    fun updateAllList(list: MutableList<ConversionsData>){
        optionsList.clear();
        var newList: MutableList<ConversionsData> = list
        optionsList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = optionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemConversionsBinding.bind(view)

        fun setListener(conversionData: ConversionsData){
            binding.cardView.setOnClickListener {
                //listener.changeVisibility(conversionData)
            }
        }
    }

}