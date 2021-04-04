package com.zyangdd.empty.extensions

import android.view.View

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.select() {
    isSelected = true
}

fun View.unSelect() {
    isSelected = false
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.setVisible(visible: Boolean) {
    if (visible) visible() else invisible()
}

fun View.setInvisible(invisible: Boolean) {
    if (invisible) invisible() else visible()
}

fun View.setGone(gone: Boolean) {
    if (gone) gone() else visible()
}

fun View.toggleVisibility(invisible: Boolean = false) {
    if (visibility == View.VISIBLE) {
        if (invisible) {
            invisible()
        } else {
            gone()
        }
    } else {
        visible()
    }
}

fun View.setSizePx(widthPx: Number, heightPx: Number) {
    val newLayoutParams = layoutParams
    newLayoutParams.width = widthPx.toInt()
    newLayoutParams.height = heightPx.toInt()
    layoutParams = newLayoutParams
}

fun View.setSizeDp(widthDp: Number, heightDp: Number) {
    setSizePx(widthDp.dpToPx(context), heightDp.dpToPx(context))
}

fun View.setSizePx(sizePx: Number) {
    setSizePx(sizePx, sizePx)
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

fun View.setHeightDp(heightDp: Number) {
    setHeightPx(heightDp.dpToPx(context))
}

fun View.setWidthPx(widthPx: Number) {
    val newLayoutParams = layoutParams
    newLayoutParams.width = widthPx.toInt()
    newLayoutParams.height = newLayoutParams.height
    layoutParams = newLayoutParams
}

fun View.setWidthDp(widthDp: Number) {
    setWidthPx(widthDp.dpToPx(context))
}

fun View.onThrottledClick(throttleDelay: Long = 300L, onClick: (View) -> Unit) {
    setOnClickListener {
        onClick(this)
        isClickable = false
        postDelayed({ isClickable = true }, throttleDelay)
    }
}