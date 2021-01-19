package com.zyangdd.empty.base.extensions

import android.animation.AnimatorInflater
import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.tabs.TabLayout

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun TabLayout.setStateListAnimator(resAnimatorId: Int) {
    if (tabCount < 1) {
        return
    }
    val childTab = getChildAt(0) as ViewGroup
    for (i in 0 until tabCount) {
        val containerTabContent = childTab.getChildAt(i) as ViewGroup
        containerTabContent.stateListAnimator =
            AnimatorInflater.loadStateListAnimator(context, resAnimatorId)
    }
}

fun TabLayout.updateFont(
    fontNormal: Int,
    fontSelected: Int,
    selectedIndex: Int
) {
    if (tabCount < 1) {
        return
    }
    val childTab = getChildAt(0) as ViewGroup
    for (i in 0 until tabCount) {
        val containerTabContent = childTab.getChildAt(i) as ViewGroup
        val textView = containerTabContent.getChildAt(1) as TextView
        textView.setFont(fontNormal)
    }
    val containerTabContent = childTab.getChildAt(selectedIndex) as ViewGroup
    val textView = containerTabContent.getChildAt(1) as TextView
    textView.setFont(fontSelected)
}