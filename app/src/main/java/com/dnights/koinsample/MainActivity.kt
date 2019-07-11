package com.dnights.koinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dnights.koinsample.app.BusinessService
import com.dnights.koinsample.di.myModule
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    // lazy inject BusinessService into property
    val service : BusinessService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // or directly get any instance
        val service2 : BusinessService = get()

    }
}
