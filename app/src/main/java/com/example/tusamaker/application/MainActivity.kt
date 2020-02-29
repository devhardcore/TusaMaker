package com.example.tusamaker.application

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tusamaker.FragmentHelper
import com.example.tusamaker.R
import com.example.tusamaker.service.ApiFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    /**
     * MainActivity creates background activity for fragments, loads a list of events
     */
    private val fragmentHelper = FragmentHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        supportActionBar?.hide()

        val eventService = ApiFactory.tmApi
        GlobalScope.launch(Dispatchers.Main) {
            val allEvents = eventService.getAllEventsAsync()
            val responseAll = allEvents.await()

            if (responseAll.isSuccessful) {
                val eventResponse = responseAll.body()
                val listEvents = eventResponse?.results
                Log.i("Rainbow Pony API", listEvents.toString())
            } else {
                Log.e("Rainbow Pony API", "ERROR!")
            }
        }

        fragmentHelper.openHome()
        navView.setOnNavigationItemSelectedListener(fragmentHelper.onNavigationItemSelectedListener)
    }
}
