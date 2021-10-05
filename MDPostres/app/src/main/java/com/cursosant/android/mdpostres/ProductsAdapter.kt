package com.cursosant.android.mdpostres

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.card.MaterialCardView

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
class ProductsAdapter(private val products: List<Product>, private val listener: OnClickListener) :
        RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.setListener(product, listener)
        holder.tvName.text = product.name

        Glide.with(context!!)
                .load(product.url)
                .apply(RequestOptions().centerCrop())
                .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView
        var tvName: TextView
        var viewContainer: MaterialCardView

        fun setListener(product: Product, listener: OnClickListener) {
            viewContainer.setOnClickListener { view: View? ->
                product.isSelected = !product.isSelected
                viewContainer.isChecked = product.isSelected
                listener.onClick(product)
            }
        }

        init {
            imgPhoto = itemView.findViewById(R.id.imgPhoto)
            tvName = itemView.findViewById(R.id.tvName)
            viewContainer = itemView as MaterialCardView
        }
    }
}