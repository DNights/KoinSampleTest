package com.dnights.koinsample.app

import android.app.Application
import com.dnights.koinsample.di.myModule
import com.dnights.koinsample.di.ticTacToeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        stopKoin()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(
                listOf(myModule, ticTacToeModule)
            )
        }
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }
}
