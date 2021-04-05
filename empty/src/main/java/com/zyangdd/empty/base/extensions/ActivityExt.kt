package com.zyangdd.empty.base.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import com.zyangdd.empty.base.BaseActivity

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity<*> = this as BaseActivity<*>

fun Activity.showKeyboard(view: View?) {
    view?.showKeyboard()
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    view?.hideKeyboard()
}

fun BaseActivity<*>.showToast(messageRes: Int) {
    showToast(getString(messageRes))
}