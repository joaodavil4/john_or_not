package com.jp.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setWidgets()
    }

    private fun setWidgets(){
        findViewById<Button>(R.id.bt_learn_more)?.setOnClickListener {
            //
        }
    }
}