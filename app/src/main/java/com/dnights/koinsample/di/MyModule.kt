package com.dnights.koinsample.di

import com.dnights.koinsample.controller.Controller
import com.dnights.koinsample.service.BusinessService
import org.koin.dsl.module

val myModule = module {
    single { Controller(get()) }
    single { BusinessService() }
}