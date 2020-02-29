package com.example.omskalive.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.omskalive.FragmentHelper
import com.example.omskalive.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val fragmentHelper = FragmentHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportActionBar?.hide()
        fragmentHelper.openHome()
        navView.setOnNavigationItemSelectedListener(fragmentHelper.onNavigationItemSelectedListener)
    }
}
