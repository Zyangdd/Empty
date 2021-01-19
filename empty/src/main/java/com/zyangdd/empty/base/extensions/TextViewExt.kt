package com.zyangdd.empty.base.extensions

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat

fun TextView.setFont(fontRes: Int) {
    val typeface = ResourcesCompat.getFont(context, fontRes)
    setTypeface(typeface)
}

fun TextView.setTextHtml(text: String) {
    setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
}