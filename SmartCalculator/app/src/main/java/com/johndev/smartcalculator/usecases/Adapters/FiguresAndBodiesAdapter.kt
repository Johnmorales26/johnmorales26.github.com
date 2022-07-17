package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFiguresBodiesBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.squareup.picasso.Picasso

class FiguresAndBodiesAdapter(var optionsList: MutableList<FiguresAndBodies>, private val listener: OnClickListener) :
RecyclerView.Adapter<FiguresAndBodiesAdapter.ViewHolder>(){

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_figures_bodies, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val option = optionsList[position]
        Picasso.get().load(option.imgPhoto).into(holder.binding.imgPhoto)
        with(holder) {
            binding.tvTitle.text = option.nombre
            setListener(option, holder.binding.imgPhoto, holder.binding.tvTitle)
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

    override fun getItemCount(): Int = optionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemFiguresBodiesBinding.bind(view)

        fun setListener(figuresOrBodies: FiguresAndBodies, tvName: View, imgPhoto: View){
            binding.root.setOnClickListener {
                listener.onClick(figuresOrBodies, tvName, imgPhoto)
                true
            }
        }
    }
}