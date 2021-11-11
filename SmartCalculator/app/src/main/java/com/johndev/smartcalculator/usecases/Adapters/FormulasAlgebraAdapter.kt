package com.johndev.smartcalculator.usecases.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFormulasAlgebraBinding
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasAlgebraAdapter(var formulaList: MutableList<FormulasAlgebra>) : RecyclerView.Adapter<FormulasAlgebraAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulasAlgebraAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_formulas_algebra, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormulasAlgebraAdapter.ViewHolder, position: Int) {
        val formula = formulaList[position]
        holder.binding.formulaAlgebra.text = formula.formula
        holder.binding.formulaAlgebraPart2.text = formula.formulaPartTwo
    }

    override fun getItemCount(): Int = formulaList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemFormulasAlgebraBinding.bind(view)

    }

}