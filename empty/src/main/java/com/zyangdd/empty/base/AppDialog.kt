package com.zyangdd.empty.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import com.zyangdd.empty.R
import com.zyangdd.empty.base.extensions.dpToPx
import com.zyangdd.empty.databinding.DialogAppBinding

class AppDialog(context: Context) : AlertDialog(context) {

    private lateinit var binding: DialogAppBinding

    var title: String? = null
    var titleId: Int = R.string.alert
    var message: String? = null
    var messageId: Int = R.string.default_empty
    var positive: String? = null
    var positiveId: Int? = null
    var negative: String? = null
    var negativeId: Int? = null
    var neutral: String? = null
    var neutralId: Int? = null
    var onPositiveClick: (() -> Unit)? = null
    var onNegativeClick: (() -> Unit)? = null
    var onNeutralClick: (() -> Unit)? = null
    var autoDismiss = true

    override fun onCreate(savedInstanceState: Bundle?) {
        initDialog()
        super.onCreate(savedInstanceState)
        binding = DialogAppBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        initTitle()
        initMessage()
        initPositiveAction()
        initNegativeAction()
        initNeutralAction()
    }

    private fun initDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val backgroundTransparent = ColorDrawable(Color.TRANSPARENT)
        val inset = 32.dpToPx(context)
        val background = InsetDrawable(backgroundTransparent, inset.toInt())
        window?.setBackgroundDrawable(background)
    }

    private fun initTitle() {
        if (title != null) {
            binding.titleTv.text = title
        } else {
            binding.titleTv.setText(titleId)
        }
    }

    private fun initMessage() {
        if (message != null) {
            binding.messageTv.text = message
        } else {
            binding.messageTv.setText(messageId)
        }
    }

    private fun initPositiveAction() {
        if (positive != null) {
            binding.positiveTv.text = positive
        } else {
            positiveId?.let { binding.positiveTv.setText(it) }
        }
        binding.positiveTv.visibility = positiveVisibility()
        binding.positiveDividerTv.visibility = positiveDividerVisibility()

        binding.positiveTv.setOnClickListener {
            onPositiveClick?.invoke()
            if (autoDismiss) dismiss()
        }
    }

    private fun initNegativeAction() {
        if (negative != null) {
            binding.negativeTv.text = negative
        } else {
            negativeId?.let { binding.negativeTv.setText(it) }
        }
        binding.negativeTv.visibility = negativeVisibility()
        binding.negativeDividerTv.visibility = negativeDividerVisibility()

        binding.negativeTv.setOnClickListener {
            onNegativeClick?.invoke()
            if (autoDismiss) dismiss()
        }
    }

    private fun initNeutralAction() {
        if (neutral != null) {
            binding.neutralTv.text = neutral
        } else {
            neutralId?.let { binding.neutralTv.setText(it) }
        }
        val visibility = neutralVisibility()
        binding.neutralTv.visibility = visibility

        binding.neutralTv.setOnClickListener {
            onNeutralClick?.invoke()
            if (autoDismiss) dismiss()
        }
    }

    private fun positiveVisibility() =
        if (positive != null || positiveId != null) View.VISIBLE else View.GONE

    private fun negativeVisibility() =
        if (negative != null || negativeId != null) View.VISIBLE else View.GONE

    private fun neutralVisibility() =
        if (neutral != null || neutralId != null) View.VISIBLE else View.GONE

    private fun positiveDividerVisibility(): Int {
        val positiveVisible = positiveVisibility() == View.VISIBLE
        val negativeVisible = negativeVisibility() == View.VISIBLE
        val neutralVisible = neutralVisibility() == View.VISIBLE
        if (!positiveVisible)
            return View.GONE
        if (!negativeVisible && !neutralVisible)
            return View.GONE
        return View.VISIBLE
    }

    private fun negativeDividerVisibility(): Int {
        val negativeVisible = negativeVisibility() == View.VISIBLE
        val neutralVisible = neutralVisibility() == View.VISIBLE
        if (!negativeVisible)
            return View.GONE
        if (!neutralVisible)
            return View.GONE
        return View.VISIBLE
    }
}