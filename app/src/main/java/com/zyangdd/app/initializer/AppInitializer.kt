package com.zyangdd.app.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class AppInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Log.d("Test", "App Initializer")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}