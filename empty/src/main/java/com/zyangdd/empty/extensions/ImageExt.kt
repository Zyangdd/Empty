package com.zyangdd.empty.extensions

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

fun ImageView.setTintColor(color: Int) {
    setTintColor(ColorStateList.valueOf(color))
}

private fun ImageView.setTintColor(colorStateList: ColorStateList?) {
    ImageViewCompat.setImageTintList(this, colorStateList)
}