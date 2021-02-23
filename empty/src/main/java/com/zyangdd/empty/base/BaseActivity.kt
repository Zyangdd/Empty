package com.zyangdd.empty.base

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import com.zyangdd.empty.base.extensions.addRootFragment
import com.zyangdd.empty.base.extensions.getTopFragment

abstract class BaseActivity : BaseLogActivity() {
    private var currentBackStackEntryCount = 0
    private var toast: Toast? = null
    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentBackStackEntryCount = supportFragmentManager.backStackEntryCount

        setContentView(getLayoutId())
        registerOnBackStackChange()

        if (savedInstanceState == null) {
            addRootFragment(getRootFragment())
        }

        initView()
        observeData()
    }

    override fun onBackPressed() {
        val topFragment = supportFragmentManager.getTopFragment()
        if (topFragment is BaseFragment) {
            topFragment.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    fun showProgress() {
        progressDialog?.dismiss()
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
        }
        progressDialog?.show()
    }

    fun hideProgress() {
        progressDialog?.dismiss()
    }

    fun showToast(message: String?) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    // More method
    private fun registerOnBackStackChange() {
        supportFragmentManager.addOnBackStackChangedListener {
            val newCurrentBackStackEntryCount = supportFragmentManager.backStackEntryCount
            if (newCurrentBackStackEntryCount < currentBackStackEntryCount) {
                val topFragment = supportFragmentManager.getTopFragment()
                if (topFragment is BaseFragment) {
                    topFragment.onBackResume()
                }
            }
            currentBackStackEntryCount = newCurrentBackStackEntryCount
        }
    }

    abstract fun getRootFragment(): BaseFragment

    open fun getLayoutId() = ROOT_LAYOUT_ID

    fun getContainerId() = FRAGMENT_CONTAINER_ID

    open fun initView() {}

    open fun observeData() {}
}