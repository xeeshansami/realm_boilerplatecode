package com.hbl.vlinkapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.*
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import hbl.vlinkapprevame.R
import java.io.*
import java.lang.ClassCastException
import java.util.*


class Launcher : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    var permissions = arrayOf(
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.CALL_PHONE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.INTERNET,
        Manifest.permission.CHANGE_WIFI_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    fun hideNavigationBar() {
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        init()
    }

    @SuppressLint("RestrictedApi")
    private fun init() {
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            )
        )
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        switchFragment(R.id.nav_home)
    }

    private fun switchFragment(startDestId: Int) {
//        val fragmentContainer = view?.findViewById<View>(R.id.nav_host)
//        val navController = Navigation.findNavController(fragmentContainer!!)
        val navController = findNavController(R.id.nav_host_fragment)
        val inflater = navController.navInflater
        val graph = navController.graph
        graph.setStartDestination(startDestId)
        navController.graph = graph
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        // Unregister since the activity is about to be closed.
        super.onDestroy()
    }

    fun permission() {

    }
}
