package com.dnights.koinsample.app

import android.app.Application
import com.dnights.koinsample.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(myModule)
        }
    }
}
