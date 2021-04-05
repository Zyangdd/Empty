package com.zyangdd.empty.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.zyangdd.empty.base.extensions.setOnTouchHideKeyboard


abstract class BaseFragment<B : ViewBinding> : BaseLogFragment() {
    protected lateinit var binding: B

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

    abstract fun generateBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun initView()

    abstract fun observeData()

    open fun isTouchHideKeyboard() = true
}