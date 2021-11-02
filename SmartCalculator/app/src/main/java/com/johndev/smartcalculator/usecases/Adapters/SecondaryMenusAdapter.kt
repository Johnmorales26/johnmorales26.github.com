package com.johndev.smartcalculator.usecases.Adapters

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.squareup.picasso.Picasso
import com.johndev.smartcalculator.R
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.databinding.ItemSecondaryMenuBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener

class SecondaryMenusAdapter(var secondaryMenuList: MutableList<SecondaryMenus>, private val listener: OnClickListener) :
RecyclerView.Adapter<SecondaryMenusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_secondary_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operations = secondaryMenuList[position]
        Picasso.get().load(operations.img).into(holder.binding.imgPhoto)
        with(holder){
            binding.apply {
                tvTitle.text = operations.nombre
                tvFormula.text = operations.formula
            }
        }
        holder.setListener(operations, holder.binding.imgPhoto, holder.binding.tvTitle)
    }

    override fun getItemCount(): Int = secondaryMenuList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemSecondaryMenuBinding.bind(view)

        fun setListener(secondaryMenu: SecondaryMenus, tvName: View, imgPhoto: View){
            binding.root.setOnClickListener{
                listener.onClick(secondaryMenu, tvName, imgPhoto)
                true
            }
        }
    }
}