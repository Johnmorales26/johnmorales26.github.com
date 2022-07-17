package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.preference.PreferenceManager
import com.squareup.picasso.Picasso
import com.johndev.smartcalculator.R
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.usecases.base.SecondaryMenus
import com.johndev.smartcalculator.databinding.ItemSecondaryMenuBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener

class SecondaryMenusAdapter(var secondaryMenuList: MutableList<SecondaryMenus>, private val listener: OnClickListener) :
RecyclerView.Adapter<SecondaryMenusAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_secondary_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val operations = secondaryMenuList[position]
        Picasso.get().load(operations.img).into(holder.binding.imgPhoto)
        with(holder){
            binding.apply {
                tvTitle.text = operations.nombre
                tvFormula.text = operations.formula
                //--------------------------------------------
                val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                    context.getString(R.string.preference_key_color_default))
                when(theme) {
                    context.getString(R.string.preference_key_color_default) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryColor)
                    }
                    context.getString(R.string.preference_key_color_red) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryRedColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryRedColor)
                    }
                    context.getString(R.string.preference_key_color_yellow) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryYellowColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryYellowColor)
                    }
                    context.getString(R.string.preference_key_color_blue) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryBlueColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryBlueColor)
                    }
                    context.getString(R.string.preference_key_color_green) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryGreenColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryGreenColor)
                    }
                    context.getString(R.string.preference_key_color_purple) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryPurpleColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryPurpleColor)
                    }
                    context.getString(R.string.preference_key_color_orange) -> {
                        binding.tvFormula.setTextColor(context.getColor(R.color.primaryOrangeColor))
                        binding.cardView.strokeColor = context.getColor(R.color.primaryOrangeColor)
                    }
                }
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