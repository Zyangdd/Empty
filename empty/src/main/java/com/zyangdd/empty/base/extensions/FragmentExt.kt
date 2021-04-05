package com.zyangdd.empty.base.extensions

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.zyangdd.empty.AppConstants
import com.zyangdd.empty.base.BaseActivity
import com.zyangdd.empty.base.BaseFragment

fun Fragment.getBaseActivity(): BaseActivity<*>? = activity?.getBaseActivity()

fun Fragment.getBaseFragment(): BaseFragment<*> = this as BaseFragment<*>

fun Fragment.showKeyboard(view: View?) {
    view?.showKeyboard()
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Fragment.showProgress() {
    getBaseActivity()?.showProgress()
}

fun Fragment.hideProgress() {
    getBaseActivity()?.hideProgress()
}

fun Fragment.showToast(message: String) {
    getBaseActivity()?.showToast(message)
}

fun Fragment.showToast(messageRes: Int) {
    getBaseActivity()?.showToast(messageRes)
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.openRequestWriteSettings() {
    val action = Settings.ACTION_MANAGE_WRITE_SETTINGS
    val uri = Uri.parse("package:" + context?.packageName)
    val intent = Intent(action, uri)
    startActivityForResult(intent, AppConstants.RC_PERMISSION_SYSTEM_SETTING)
}

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.isCanWriteSystem() = Settings.System.canWrite(context)

private fun storagePermissions() = arrayOf(
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE
)