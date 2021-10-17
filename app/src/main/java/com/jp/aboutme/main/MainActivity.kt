package com.jp.aboutme.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.jp.aboutme.R
import com.jp.aboutme.databinding.ActivityMainBinding
import com.jp.aboutme.main.model.Me
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val me: Me = Me("Jon", "JP")
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindingObjects()
        setWidgets()
        Timber.i("onCreate Called")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }


    private fun bindingObjects(){
        binding.me = me



    }

    private fun setWidgets(){

        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)


        binding.btLearnMore.setOnClickListener {
            binding.apply {
                me?.name = "Pedro"
                invalidateAll() //UI is refreshed with the value in the updated binding object.
            }
        }
    }
}