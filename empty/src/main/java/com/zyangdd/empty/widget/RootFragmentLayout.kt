package com.zyangdd.empty.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class RootFragmentLayout : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )
}