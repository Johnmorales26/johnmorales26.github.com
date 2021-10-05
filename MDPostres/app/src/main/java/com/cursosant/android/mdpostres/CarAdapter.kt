package com.cursosant.android.mdpostres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/****
 * Project: MD Postres
 * From: com.cursosant.android.mdpostres
 * Created by Alain Nicolás Tello on 01/01/21 at 14:06
 * Course: Professional Material Desing/Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * All rights reserved 2021.
 *
 * Others:
 * Android con Kotlin intensivo y práctico desde cero.
 * https://www.udemy.com/course/kotlin-intensivo/?referralCode=93D5D2FA6EF503FD0A6B
 */

class CarAdapter(private val products: Array<String>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productStr = products[position]
        holder.tvName.text = productStr
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView

        init {
            tvName = itemView.findViewById(R.id.tvName)
        }
    }
}