package com.zyangdd.empty.extensions

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Any?.isNull() = this == null

fun Activity.openPlayStore() {
    val action = Intent.ACTION_VIEW
    try {
        val uri = Uri.parse("market://details?id=$packageName")
        startActivity(Intent(action, uri))
    } catch (e: android.content.ActivityNotFoundException) {
        val uri = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
        startActivity(Intent(action, uri))
    }
}