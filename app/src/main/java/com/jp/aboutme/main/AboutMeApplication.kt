package com.jp.aboutme.main

import android.app.Application
import timber.log.Timber

class AboutMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

    }
}
