package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemDescriptionUpdatesBinding
import com.johndev.smartcalculator.usecases.base.DescriptionUpdates

class DescriptionUpdateAdapter(private val descriptionsList: MutableList<DescriptionUpdates>) :
    RecyclerView.Adapter<DescriptionUpdateAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_description_updates, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val description = descriptionsList[position]
        with(holder){
            binding.descriptionUpdate.text = description.description.trim()
        }
    }

    override fun getItemCount(): Int = descriptionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemDescriptionUpdatesBinding.bind(view)
    }

}