package com.johndev.smartcalculator.usecases.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFiguresBodiesBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.FiguresAndBodies
import com.squareup.picasso.Picasso

class FiguresAndBodiesAdapter(var optionsList: MutableList<FiguresAndBodies>, private val listener: OnClickListener) :
RecyclerView.Adapter<FiguresAndBodiesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_figures_bodies, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = optionsList[position]
        Picasso.get().load(option.imgPhoto).into(holder.binding.imgPhoto)
        holder.binding.tvTitle.text = option.nombre
        holder.setListener(option, holder.binding.imgPhoto, holder.binding.tvTitle)
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