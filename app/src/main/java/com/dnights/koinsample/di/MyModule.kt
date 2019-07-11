package com.dnights.koinsample.di

import com.dnights.koinsample.app.BusinessService
import com.dnights.koinsample.app.Controller
import org.koin.dsl.module

val myModule = module {
    single { Controller(get()) }
    single { BusinessService() }
}