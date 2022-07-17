package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFunctionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.squareup.picasso.Picasso

class FunctionalitiesAdapter(var functionalitiesList: MutableList<Functionalities>, private val listener: OnClickListener) :
RecyclerView.Adapter<FunctionalitiesAdapter.ViewHolder>(){

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_functions, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val function = functionalitiesList[position]
        Picasso.get().load(function.img).into(holder.binding.imgFunction)
        with(holder) {
            binding.tvNameFunction.text = function.Nombre
            setListener(function, holder.binding.imgFunction, holder.binding.tvNameFunction)
            //--------------------------------------------
            val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                context.getString(R.string.preference_key_color_default))
            when(theme) {
                context.getString(R.string.preference_key_color_default) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryColor)
                }
                context.getString(R.string.preference_key_color_red) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryRedColor)
                }
                context.getString(R.string.preference_key_color_yellow) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryYellowColor)
                }
                context.getString(R.string.preference_key_color_blue) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryBlueColor)
                }
                context.getString(R.string.preference_key_color_green) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryGreenColor)
                }
                context.getString(R.string.preference_key_color_purple) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryPurpleColor)
                }
                context.getString(R.string.preference_key_color_orange) -> {
                    binding.cardView.strokeColor = context.getColor(R.color.primaryOrangeColor)
                }
            }
        }
    }

    override fun getItemCount(): Int = functionalitiesList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemFunctionsBinding.bind(view)

        fun setListener(functionality: Functionalities, tvName: View, imgPhoto: View){
            binding.root.setOnClickListener {
                listener.onClick(functionality, tvName, imgPhoto)
                true
            }
        }
    }

}