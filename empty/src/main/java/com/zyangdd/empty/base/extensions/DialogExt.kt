package com.zyangdd.empty.base.extensions

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
fun Dialog.configBottomSheetBackground() {
    val dimDrawable = GradientDrawable()
    val navigationBarDrawable = GradientDrawable()
    navigationBarDrawable.shape = GradientDrawable.RECTANGLE
    navigationBarDrawable.setColor(Color.WHITE)
    val layers = arrayOf<Drawable>(dimDrawable, navigationBarDrawable)
    val windowBackground = LayerDrawable(layers)
    windowBackground.setLayerInsetTop(1, context.getHeightScreenPx())
    window?.setBackgroundDrawable(windowBackground)
}