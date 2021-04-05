package com.zyangdd.empty.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.zyangdd.empty.base.extensions.setOnTouchHideKeyboard

abstract class BaseDialogFragment<B : ViewBinding> : DialogFragment() {
    protected lateinit var binding: B

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        initDialogWindow()
    }

    private fun initDialogWindow() {
        dialog?.window?.apply {
            requestFeature(Window.FEATURE_NO_TITLE)
            statusBarColor = Color.TRANSPARENT
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(gravity())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = generateBinding(inflater, container)
        val view = binding.root
        view.isClickable = true
        if (isTouchHideKeyboard()) {
            view.setOnTouchHideKeyboard(null)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(width(), height())
    }

    abstract fun generateBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun initView()

    abstract fun observeData()

    open fun gravity() = Gravity.CENTER

    open fun width() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun height() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun isTouchHideKeyboard() = true
}