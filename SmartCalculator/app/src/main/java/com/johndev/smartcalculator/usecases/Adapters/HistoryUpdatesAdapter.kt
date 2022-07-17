package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.MainActivity
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemHistoyUpdatesBinding
import com.johndev.smartcalculator.usecases.base.HistoryUpdates

class HistoryUpdatesAdapter(private val histUpdatesList: MutableList<HistoryUpdates>) :
    RecyclerView.Adapter<HistoryUpdatesAdapter.ViewHolder>(){

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_histoy_updates, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyUpdates = histUpdatesList[position]
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        holder.apply {
            binding.tvVersion.text = historyUpdates.version.trim()


            var historyUpdatesAdapter = DescriptionUpdateAdapter(historyUpdates.descriptionFunctionUpdates)
            binding.recyclerViewFunctions.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = historyUpdatesAdapter
            }

            historyUpdatesAdapter = DescriptionUpdateAdapter(historyUpdates.descriptionFormulasUpdates)
            binding.recyclerViewFormulas.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = historyUpdatesAdapter
            }

            historyUpdatesAdapter = DescriptionUpdateAdapter(historyUpdates.descriptionOtherUpdates)
            binding.recyclerViewUpdates.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = historyUpdatesAdapter
            }
            
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

    override fun getItemCount(): Int = histUpdatesList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemHistoyUpdatesBinding.bind(view)
    }

}