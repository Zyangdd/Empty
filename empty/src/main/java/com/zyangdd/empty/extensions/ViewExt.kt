package com.zyangdd.empty.extensions

import android.view.View

fun View.setSizePx(widthPx: Number, heightPx: Number) {
    val newLayoutParams = layoutParams
    newLayoutParams.width = widthPx.toInt()
    newLayoutParams.height = heightPx.toInt()
    layoutParams = newLayoutParams
}

fun View.setSizePx(sizePx: Number) {
    setSizePx(sizePx, sizePx)
}

fun View.setSizeDp(widthDp: Number, heightDp: Number) {
    setSizePx(widthDp.dpToPx(context), heightDp.dpToPx(context))
}

fun View.setSizeDp(sizeDp: Int) {
    setSizePx(sizeDp.dpToPx(context))
}


fun View.setHeightPx(heightPx: Number) {
    val newLayoutParams = layoutParams
    newLayoutParams.width = newLayoutParams.width
    newLayoutParams.height = heightPx.toInt()
    layoutParams = newLayoutParams
}

fun View.setWidthPx(widthPx: Number) {
    val newLayoutParams = layoutParams
    newLayoutParams.width = widthPx.toInt()
    newLayoutParams.height = newLayoutParams.height
    layoutParams = newLayoutParams
}

fun View.setHeightDp(heightDp: Number) {
    setHeightPx(heightDp.dpToPx(context))
}

fun View.setWidthDp(widthDp: Number) {
    setWidthPx(widthDp.dpToPx(context))
}