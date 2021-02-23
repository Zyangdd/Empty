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
import pub.devrel.easypermissions.EasyPermissions

abstract class BaseDialogFragment<B : ViewBinding> : DialogFragment() {
    val binding: B by lazy { viewBinding() }

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
        val view = binding.root
        view.isClickable = true
        if (isTouchHideKeyboard()) {
            view.setOnTouchHideKeyboard(null)
        }
        initView()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeData()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(width(), height())
    }

    override fun onRequestPermissionsResult(rc: Int, perms: Array<out String>, results: IntArray) {
        super.onRequestPermissionsResult(rc, perms, results)
        EasyPermissions.onRequestPermissionsResult(rc, perms, results, this)
    }

    abstract fun viewBinding(): B

    abstract fun initView()

    abstract fun observeData()

    open fun gravity() = Gravity.CENTER

    open fun width() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun height() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun isTouchHideKeyboard() = true
}