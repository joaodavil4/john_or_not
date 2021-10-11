package com.jp.aboutme.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jp.aboutme.R
import com.jp.aboutme.databinding.ActivityMainBinding
import com.jp.aboutme.main.model.Me

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val me: Me = Me("Jon", "JP")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindingObjects()
        setWidgets()
    }

    private fun bindingObjects(){
        binding.me = me

    }

    private fun setWidgets(){
        binding.btLearnMore.setOnClickListener {
            binding.apply {
                me?.name = "Pedro"
                invalidateAll() //UI is refreshed with the value in the updated binding object.
            }
        }
    }
}