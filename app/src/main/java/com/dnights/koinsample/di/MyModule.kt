package com.dnights.koinsample.di

import com.dnights.koinsample.controller.Controller
import com.dnights.koinsample.service.BusinessService
import com.dnights.koinsample.viewmodel.TicTacToeViewModel
import org.koin.dsl.module

/**
 * sample myModule
 */

val myModule = module {
    single { Controller(get()) }
    single { BusinessService() }
}

val ticTacToeModule = module {
    factory { TicTacToeViewModel() }
}