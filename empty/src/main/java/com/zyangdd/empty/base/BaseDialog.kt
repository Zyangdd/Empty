package com.zyangdd.empty.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<B : ViewBinding>(context: Context) : AlertDialog(context) {
    val binding: B by lazy { viewBinding() }
    override fun onCreate(savedInstanceState: Bundle?) {
        initDialogWindow()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        observeData()
    }

    private fun initDialogWindow() {
        window?.apply {
            requestFeature(Window.FEATURE_NO_TITLE)
            statusBarColor = Color.TRANSPARENT
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(gravity())
        }
    }

    override fun onStart() {
        super.onStart()
        window?.setLayout(width(), height())
    }

    abstract fun viewBinding(): B

    abstract fun initView()

    abstract fun observeData()

    open fun gravity() = Gravity.CENTER

    open fun width() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun height() = ViewGroup.LayoutParams.MATCH_PARENT
}