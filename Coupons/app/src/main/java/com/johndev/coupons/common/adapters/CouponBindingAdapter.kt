package com.johndev.coupons.common.adapters

import android.graphics.Color
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.johndev.coupons.R

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) GONE else VISIBLE
}

@BindingAdapter("textTitle")
fun bindTextTitle(view: MaterialTextView, isActive: Boolean) {
    if (isActive) {
        view.setText(R.string.main_text_title)
        view.setTextColor(Color.BLACK)
    } else {
        view.setText(R.string.main_text_title_create)
        view.setTextColor(Color.MAGENTA)
    }
}