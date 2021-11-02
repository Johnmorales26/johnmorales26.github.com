package com.johndev.smartcalculator.usecases.Adapters

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFunctionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.Functionalities
import com.squareup.picasso.Picasso

class FunctionalitiesAdapter(var functionalitiesList: MutableList<Functionalities>, private val listener: OnClickListener) :
RecyclerView.Adapter<FunctionalitiesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_functions, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val function = functionalitiesList[position]
        Picasso.get().load(function.img).into(holder.binding.imgFunction)
        holder.binding.tvNameFunction.text = function.Nombre
        holder.setListener(function, holder.binding.imgFunction, holder.binding.tvNameFunction)
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