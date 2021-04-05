package com.zyangdd.empty.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseLogFragment : Fragment() {
    @SuppressLint("LogNotTimber")
    protected fun log(log: String) {
        Log.e(LOG_TAG_LIFECYCLE, "$this-$log")
    }

    override fun onAttach(context: Context) {
        log("OnAttach_1")
        super.onAttach(context)
        log("OnAttach_2")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        log("onCreate_1")
        super.onCreate(savedInstanceState)
        log("onCreate_2")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("onCreateView")
        return null
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        log("onViewCreated_1")
        super.onViewCreated(view, savedInstanceState)
        log("onViewCreated_2")
    }

    override fun onStart() {
        log("onStart_1")
        super.onStart()
        log("onStart_2")
    }

    override fun onResume() {
        log("onResume_1")
        super.onResume()
        log("onResume_2")
    }

    override fun onPause() {
        log("onPause_1")
        super.onPause()
        log("onPause_2")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        log("onSaveInstanceState_1")
        super.onSaveInstanceState(outState)
        log("onSaveInstanceState_2")
    }

    override fun onStop() {
        log("onStop_1")
        super.onStop()
        log("onStop_2")
    }

    override fun onDestroyView() {
        log("onDestroyView_1")
        super.onDestroyView()
        log("onDestroyView_2")
    }

    override fun onDestroy() {
        log("onDestroy_1")
        super.onDestroy()
        log("onDestroy_2")
    }

    override fun onDetach() {
        log("onDetach_1")
        super.onDetach()
        log("onDetach_2")
    }
}