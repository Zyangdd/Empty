package com.zyangdd.empty.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zyangdd.empty.base.extensions.configBottomSheetBackground
import com.zyangdd.empty.base.extensions.getHeightScreenPx
import pub.devrel.easypermissions.EasyPermissions

abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {
    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        initDialogWindow()
    }

    private fun initDialogWindow() {
        dialog?.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                configBottomSheetBackground()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    override fun onStart() {
        super.onStart()
        initBottomSheetState()
    }

    private fun initBottomSheetState() {
        dialog?.apply {
            val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(view?.parent as View)
            behavior.state = state()

            (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)
            if (isCustomHeight()) {
                view?.layoutParams?.height = height()
            }
        }
    }

    override fun onRequestPermissionsResult(rc: Int, perms: Array<out String>, results: IntArray) {
        super.onRequestPermissionsResult(rc, perms, results)
        EasyPermissions.onRequestPermissionsResult(rc, perms, results, this)
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun observeData()

    open fun height() = requireContext().getHeightScreenPx()

    open fun isCustomHeight() = false

    open fun state() = BottomSheetBehavior.STATE_EXPANDED
}