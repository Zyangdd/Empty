package com.zyangdd.empty.base

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.zyangdd.empty.base.extensions.configBottomSheetBackground
import com.zyangdd.empty.base.extensions.getHeightScreenPx

abstract class BaseBottomSheetDialog<B : ViewBinding>(context: Context) :
    BottomSheetDialog(context) {
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDialogWindow()
        binding = generateBinding()
        val view = binding.root
        setContentView(view)
        initBottomSheetState(view)

        initView()
        observeData()
    }

    private fun initDialogWindow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            configBottomSheetBackground()
        }
    }

    private fun initBottomSheetState(view: View) {
        behavior.state = state()
        (view.parent as View).setBackgroundColor(Color.TRANSPARENT)
        if (isCustomHeight()) {
            view.layoutParams.height = height()
        }
    }

    override fun onStart() {
        super.onStart()
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    abstract fun generateBinding(): B

    abstract fun initView()

    abstract fun observeData()

    open fun height() = context.getHeightScreenPx()

    open fun isCustomHeight() = false

    open fun state() = BottomSheetBehavior.STATE_EXPANDED
}