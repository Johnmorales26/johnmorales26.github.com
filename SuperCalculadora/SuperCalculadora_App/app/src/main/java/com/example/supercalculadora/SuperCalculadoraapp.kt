package com.example.supercalculadora

import android.app.Application
import com.google.android.gms.ads.MobileAds

class SuperCalculadoraapp: Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}
