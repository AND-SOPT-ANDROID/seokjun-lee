package org.sopt.and

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WavveApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}