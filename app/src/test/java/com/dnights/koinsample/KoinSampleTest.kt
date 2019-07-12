package com.dnights.koinsample

import com.dnights.koinsample.di.myModule
import com.dnights.koinsample.service.BusinessService
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class KoinSampleTest : KoinTest {

    // lazy inject BusinessService into property
    val service : BusinessService by inject()

    @Test
    fun myTest() {
        // You can start your Koin configuration
        startKoin { modules(myModule) }
        
        // or directly get any instance
        //val service : BusinessService = get()

        assert(service.sayHello() == "BusinessService Hello")
    }
}