package com.zyangdd.empty.base

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.zyangdd.empty.base.extensions.setOnTouchHideKeyboard
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

abstract class BaseDialogFragment : DialogFragment(), EasyPermissions.PermissionCallbacks {

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

        val view = inflater.inflate(getLayoutId(), container, false)
        view.isClickable = true
        if (isTouchHideKeyboard()) {
            view.setOnTouchHideKeyboard(null)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        observeData()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(width(), height())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initViewModel()

    abstract fun initView()

    abstract fun observeData()

    open fun gravity() = Gravity.CENTER

    open fun width() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun height() = ViewGroup.LayoutParams.MATCH_PARENT

    open fun isTouchHideKeyboard() = true
}