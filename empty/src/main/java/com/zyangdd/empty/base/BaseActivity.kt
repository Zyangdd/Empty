package com.zyangdd.empty.base

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : BaseLogActivity() {
    protected lateinit var binding: B

    private var toast: Toast? = null
    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = generateBinding()
        setContentView(binding.root)

        initView()
        observeData()
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

    abstract fun generateBinding(): B

    abstract fun initView()

    abstract fun observeData()
}