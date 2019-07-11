package com.dnights.koinsample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

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

// Given some classes
class Controller(val service : BusinessService)
class BusinessService()

// just declare it
val myModule = module {
    single { Controller(get()) }
    single { BusinessService() }
}