package com.zyangdd.empty.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyangdd.empty.base.extensions.setOnTouchHideKeyboard
import pub.devrel.easypermissions.EasyPermissions


abstract class BaseFragment : BaseLogFragment(), EasyPermissions.PermissionCallbacks {
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
        initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeData()
    }

    override fun onRequestPermissionsResult(rc: Int, perms: Array<out String>, results: IntArray) {
        super.onRequestPermissionsResult(rc, perms, results)
        EasyPermissions.onRequestPermissionsResult(rc, perms, results, this)
    }

    abstract fun getLayoutId(): Int

    open fun initView() {}

    open fun observeData() {}

    open fun onBackResume() {}

    open fun onBackPressed() = parentFragmentManager.popBackStack()

    open fun isTouchHideKeyboard() = true
}