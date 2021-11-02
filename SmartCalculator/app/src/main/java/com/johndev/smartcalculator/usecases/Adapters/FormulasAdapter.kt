package com.johndev.smartcalculator.usecases.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFormulasBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListener
import com.johndev.smartcalculator.usecases.base.Formulas
import com.johndev.smartcalculator.usecases.base.Functionalities

class FormulasAdapter(var formulasList: MutableList<Formulas>, private val listener: OnClickListener) :
RecyclerView.Adapter<FormulasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_formulas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val formula = formulasList[position]
        holder.binding.tvFormula.text = formula.Nombre
        holder.setListener(formula, holder.binding.tvFormula)
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