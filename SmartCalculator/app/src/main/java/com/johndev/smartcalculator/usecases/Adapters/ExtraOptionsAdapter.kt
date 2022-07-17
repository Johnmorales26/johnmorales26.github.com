package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemExtraOptionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerExtraOptions
import com.johndev.smartcalculator.usecases.base.ExtraOptions
import com.squareup.picasso.Picasso

class ExtraOptionsAdapter(var optionsList: MutableList<ExtraOptions>, private val listener: OnClickListenerExtraOptions) :
RecyclerView.Adapter<ExtraOptionsAdapter.ViewHolder>(){

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_extra_options, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val option = optionsList[position]
        Picasso.get().load(option.imgOption).into(holder.binding.imgExtraOption)
        with(holder) {
            binding.tvExtraOption.text = option.nameOption
            setListener(option, holder.binding.imgExtraOption, holder.binding.tvExtraOption)
            //--------------------------------------------
            val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                context.getString(R.string.preference_key_color_default))
            when(theme) {
                context.getString(R.string.preference_key_color_default) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryColor)
                }
                context.getString(R.string.preference_key_color_red) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryRedColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryRedColor)
                }
                context.getString(R.string.preference_key_color_yellow) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryYellowColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryYellowColor)
                }
                context.getString(R.string.preference_key_color_blue) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryBlueColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryBlueColor)
                }
                context.getString(R.string.preference_key_color_green) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryGreenColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryGreenColor)
                }
                context.getString(R.string.preference_key_color_purple) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryPurpleColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryPurpleColor)
                }
                context.getString(R.string.preference_key_color_orange) -> {
                    binding.tvLabel.setTextColor(context.getColor(R.color.primaryOrangeColor))
                    binding.cardView.strokeColor = context.getColor(R.color.primaryOrangeColor)
                }
            }
        }
    }

    override fun getItemCount(): Int = optionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemExtraOptionsBinding.bind(view)

        fun setListener(extraOptions: ExtraOptions, tvName: View, imgPhoto: View){
            binding.root.setOnClickListener {
                listener.onClick(extraOptions, tvName, imgPhoto)
                true
            }
        }
    }
}