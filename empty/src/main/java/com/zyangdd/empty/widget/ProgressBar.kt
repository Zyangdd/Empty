package com.zyangdd.empty.widget

import android.animation.AnimatorInflater
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.zyangdd.empty.R

class ProgressBar : ConstraintLayout {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.progress_bar, this, true)

        val progress = findViewById<View>(R.id.progress)
        val animatorProgress =
            AnimatorInflater.loadAnimator(context, R.animator.anim_progress_circle)
        animatorProgress.setTarget(progress)
        animatorProgress.start()

        val icon = findViewById<View>(R.id.icon)
        val animatorIcon = AnimatorInflater.loadAnimator(context, R.animator.anim_progress_icon)
        animatorIcon.setTarget(icon)
        animatorIcon.start()
    }
}