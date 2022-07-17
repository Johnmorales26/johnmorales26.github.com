package com.johndev.smartcalculator.usecases.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.ColorsExtra
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemFormulasAlgebraBinding
import com.johndev.smartcalculator.usecases.base.FormulasAlgebra

class FormulasAlgebraAdapter(var formulaList: MutableList<FormulasAlgebra>) : RecyclerView.Adapter<FormulasAlgebraAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var sharedPreferences: SharedPreferences
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulasAlgebraAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_formulas_algebra, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormulasAlgebraAdapter.ViewHolder, position: Int) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val formula = formulaList[position]
        with(holder) {
            binding.formulaAlgebra.text = formula.formula
            binding.formulaAlgebraPart2.text = formula.formulaPartTwo
            //--------------------------------------------
            val theme = sharedPreferences.getString(context.getString(R.string.key_preference_application_color),
                context.getString(R.string.preference_key_color_default))
            when(theme) {
                context.getString(R.string.preference_key_color_default) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryPurpleColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_red) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryRedColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_yellow) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryYellowColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_blue) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryBlueColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_green) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryGreenColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_purple) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryPurpleColor), PorterDuff.Mode.SRC)
                }
                context.getString(R.string.preference_key_color_orange) -> {
                    binding.separator.background.setColorFilter(Color.parseColor(ColorsExtra.primaryOrangeColor), PorterDuff.Mode.SRC)
                }
            }
        }
    }

    override fun getItemCount(): Int = formulaList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemFormulasAlgebraBinding.bind(view)

    }

}