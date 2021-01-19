package com.zyangdd.empty.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import com.zyangdd.empty.base.extensions.pxToDp

object DisplayUtils {

    fun spToPx(context: Context, sp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics
        ).toInt()
    }

    fun dpToPx(context: Context, dp: Float): Int {
        return (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    fun pxToDp(context: Context, px: Float): Int {
        return (px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    fun getScreenWidthPx(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeightPx(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun getScreenWidthDp(context: Context): Int {
        return getScreenWidthPx().pxToDp(context).toInt()
    }

    fun getScreenHeightDp(context: Context): Int {
        return getScreenHeightPx().pxToDp(context).toInt()
    }

    fun getScreenOrientation(context: Context): Int {
        val orientation = (context as? Activity)?.resources?.configuration?.orientation
        return orientation ?: ORIENTATION_PORTRAIT
    }

    private fun getNavigationBarHeight(context: Context): Int {
        val resourceId =
            context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else 0
    }
}
