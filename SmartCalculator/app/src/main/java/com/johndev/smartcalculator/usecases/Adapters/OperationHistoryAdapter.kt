package com.johndev.smartcalculator.usecases.Adapters

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johndev.smartcalculator.R
import com.johndev.smartcalculator.databinding.ItemOperationHistoryBinding
import com.johndev.smartcalculator.usecases.Interfaces.OnClickListenerHistory
import com.johndev.smartcalculator.usecases.base.OperationHistory
import com.squareup.picasso.Picasso

class OperationHistoryAdapter(private var optionsList: MutableList<OperationHistory>, private val listener: OnClickListenerHistory) :
    RecyclerView.Adapter<OperationHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationHistoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_operation_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = optionsList[position]
        // Obligatory Parameters
        history.image.let { Picasso.get().load(it).into(holder.binding.imgFigure) }
        holder.binding.tvTitle.text = history.nameFigure
        // Optional Parameters
        if (history.sideA != 0.0){
            holder.apply {
                with(binding){
                    tvSideA.visibility = VISIBLE
                    tvSideA.text = "Lado A: " + history.sideA.toString()
                }
            }
        }
        if (history.sideB != 0.0){
            holder.apply {
                with(binding){
                    tvSideB.visibility = VISIBLE
                    tvSideB.text = "Lado B: " + history.sideB.toString()
                }
            }
        }
        if (history.sideC != 0.0){
            holder.apply {
                with(binding){
                    tvSideC.visibility = VISIBLE
                    tvSideC.text = "Lado C: " + history.sideC.toString()
                }
            }
        }
        if (history.height != 0.0){
            holder.apply {
                with(binding){
                    tvHeight.visibility = VISIBLE
                    tvHeight.text = "Altura: " + history.height.toString()
                }
            }
        }
        if (history.width != 0.0){
            holder.apply {
                with(binding){
                    tvWidth.visibility = VISIBLE
                    tvWidth.text = "Ancho: " + history.width.toString()
                }
            }
        }
        if (history.radiusA != 0.0){
            holder.apply {
                with(binding){
                    tvRadiusA.visibility = VISIBLE
                    tvRadiusA.text = "Radio A: " + history.radiusA.toString()
                }
            }
        }
        if (history.radiusB != 0.0){
            holder.apply {
                with(binding){
                    tvRadiusB.visibility = VISIBLE
                    tvRadiusB.text = "Radio B: " + history.radiusB.toString()
                }
            }
        }
        if (history.radiusC != 0.0){
            holder.apply {
                with(binding){
                    tvRadiusC.visibility = VISIBLE
                    tvRadiusC.text = "Radio C: " + history.radiusC.toString()
                }
            }
        }
        if (history.angleA != 0.0){
            holder.apply {
                with(binding){
                    tvAngleA.visibility = VISIBLE
                    tvAngleA.text = "Θ: " + history.angleA.toString() + "°"
                }
            }
        }
        // Diferent Types Of Results
        if (history.area != null){
            holder.apply {
                with(binding){
                    tvResultArea.visibility = VISIBLE
                    tvResultArea.text = "Area: " + history.area.toString()
                }
            }
        }
        if (history.perimeter != null){
            holder.apply {
                with(binding){
                    tvResultPerimeter.visibility = VISIBLE
                    tvResultPerimeter.text = "Perimetro: " + history.perimeter.toString()
                }
            }
        }
        if (history.angleAB != null){
            holder.apply {
                with(binding){
                    tvResultAngleAB.visibility = VISIBLE
                    tvResultAngleAB.text = "Angulo AB: " + history.angleAB.toString() + "°"
                }
            }
        }
        if (history.angleBC != null){
            holder.apply {
                with(binding){
                    tvResultAngleBC.visibility = VISIBLE
                    tvResultAngleBC.text = "Angulo BC: " + history.angleBC.toString() + "°"
                }
            }
        }
        if (history.angleAC != null){
            holder.apply {
                with(binding){
                    tvResultAngleAC.visibility = VISIBLE
                    tvResultAngleAC.text = "Angulo AC: " + history.angleAC.toString() + "°"
                }
            }
        }
        if (history.heightA != null){
            holder.apply {
                with(binding){
                    tvResultHeightA.visibility = VISIBLE
                    tvResultHeightA.text = "Altura A: " + history.heightA.toString()
                }
            }
        }
        if (history.heightB != null){
            holder.apply {
                with(binding){
                    tvResultHeightB.visibility = VISIBLE
                    tvResultHeightB.text = "Altura B: " + history.heightB.toString()
                }
            }
        }
        if (history.heightC != null){
            holder.apply {
                with(binding){
                    tvResultHeightC.visibility = VISIBLE
                    tvResultHeightC.text = "Altura C: " + history.heightC.toString()
                }
            }
        }
        if (history.lateralArea != null){
            holder.apply {
                with(binding){
                    tvResultLateralArea.visibility = VISIBLE
                    tvResultLateralArea.text = "Area Lateral: " + history.lateralArea.toString()
                }
            }
        }
        if (history.volume != null) {
            holder.apply {
                with(binding){
                    tvResultVolume.visibility = VISIBLE
                    tvResultVolume.text = "Volumen: " + history.volume.toString()
                }
            }
        }
        //holder.setListener(h, holder.binding.tvFormula)
    }

    override fun getItemCount(): Int = optionsList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemOperationHistoryBinding.bind(view)

        fun setListener(history: OperationHistory, tvName: View){
            binding.root.setOnClickListener {
                listener.onClick(history)
            }
        }
    }

}