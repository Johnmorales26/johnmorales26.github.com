package com.johndev.smartcalculator.usecases.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemExtraOptionsBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerExtraOptions
import com.johndev.smartcalculator.usecases.base.ExtraOptions
import com.squareup.picasso.Picasso

class ExtraOptionsAdapter(var optionsList: MutableList<ExtraOptions>, private val listener: OnClickListenerExtraOptions) :
RecyclerView.Adapter<ExtraOptionsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_extra_options, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = optionsList[position]
        Picasso.get().load(option.imgOption).into(holder.binding.imgExtraOption)
        holder.binding.tvExtraOption.text = option.nameOption
        holder.setListener(option, holder.binding.imgExtraOption, holder.binding.tvExtraOption)
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