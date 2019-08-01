package com.dnights.koinsample.ui

import android.content.Intent
import android.os.Bundle
import com.dnights.koinsample.R
import com.dnights.koinsample.service.BusinessService
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(){

    // lazy inject BusinessService into property
    private val service : BusinessService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // or directly get any instance
        //val service : BusinessService = get()

        maintext.text = service.sayHello()

        startActivity(Intent(this, TicTacToeActivity::class.java))
    }
}
