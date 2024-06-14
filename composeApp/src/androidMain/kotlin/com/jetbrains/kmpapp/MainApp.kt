package com.jetbrains.kmpapp

import android.app.Application
import com.jetbrains.kmpapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            preInit = {
                androidContext(this@MainApp)
            }
        )
    }
}
