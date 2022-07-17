package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFormulasBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities

class FormulasAdapter(var formulasList: MutableList<Formulas>, private val listener: OnClickListener) :
RecyclerView.Adapter<FormulasAdapter.ViewHolder>(){

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_formulas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val formula = formulasList[position]
        with(holder) {
            binding.tvFormula.text = formula.Nombre
            setListener(formula, holder.binding.tvFormula)
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

    override fun getItemCount(): Int = formulasList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemFormulasBinding.bind(view)

        fun setListener(formulas: Formulas, tvName: View){
            binding.root.setOnClickListener {
                listener.onClick(formulas, tvName)
                true
            }
        }
    }

}