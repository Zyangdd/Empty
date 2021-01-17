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

//    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
//        return WindowInsets.Builder(insets)
//            .setSystemWindowInsets(
//                Insets.of(0, 0, 0, insets.systemWindowInsetBottom)
//            ).build()
//    }
}