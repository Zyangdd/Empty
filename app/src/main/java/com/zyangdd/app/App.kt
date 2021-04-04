package com.zyangdd.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        Log.d("Test", "App start")
        super.onCreate()
        Log.d("Test", "App start end")
    }
}