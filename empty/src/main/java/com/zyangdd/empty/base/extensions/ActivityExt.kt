package com.zyangdd.empty.base.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import com.zyangdd.empty.base.BaseActivity
import com.zyangdd.empty.base.BaseFragment

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity = this as BaseActivity

fun Activity.showKeyboard(view: View?) {
    view?.showKeyboard()
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    view?.hideKeyboard()
}

fun BaseActivity.showToast(messageRes: Int) {
    showToast(getString(messageRes))
}

fun BaseActivity.addRootFragment(fragment: BaseFragment) {
    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    supportFragmentManager.attachFragment(
        fragment = fragment,
        containerId = getContainerId(),
        isAddToBackStack = false,
        isReplace = true,
        isWithAnim = false
    )
}