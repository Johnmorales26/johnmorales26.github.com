/*package com.johndev.smartcalculator.usecases.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.databinding.ItemFunctionsBinding
import com.squareup.picasso.Picasso

class FunctionsAdapter(var functionsList: List<Function>, var listener: OnClickListener) :
    RecyclerView.Adapter<FunctionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFunctionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val function = functionsList[position]
        holder.setListener(function, listener)
        holder.tvNameFunction.text = function.name
        Picasso.get().load(function.img).into(holder.imgFunction)
    }

    override fun getItemCount(): Int {
        return functionsList.size
    }

    inner class ViewHolder(var binding: ItemFunctionsBinding): RecyclerView.ViewHolder(binding.root) {

        var imgFunction = binding.imgFunction
        var tvNameFunction = binding.tvNameFunction

        fun setListener(function: Function, listener: OnClickListener){
            binding.root.setOnClickListener {
                listener.onClick(function)
            }
        }

    }
}*/