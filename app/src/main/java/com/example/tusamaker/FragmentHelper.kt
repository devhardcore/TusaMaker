package com.example.tusamaker

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.tusamaker.application.AddEvent
import com.example.tusamaker.application.Home
import com.example.tusamaker.application.Search
import com.example.tusamaker.application.Selections
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.core.KoinComponent

class FragmentHelper(private val activity: FragmentActivity) : KoinComponent {
    private val home = Home()
    private val selections = Selections()
    private val add = AddEvent()
    private val search = Search()


    val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_search -> {
                    openFragment(search)
                    Log.i("FragmentHelper", "Opened Home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_home -> {
                    openFragment(home)
                    Log.i("FragmentHelper", "Opened Events")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_add -> {
                    openFragment(add)
                    Log.i("FragmentHelper", "Opened Add")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_selections -> {
                    openFragment(selections)
                    Log.i("FragmentHelper", "Opened Search")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        if (fragment.isVisible)
            return
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    fun openHome() {
        openFragment(home)
        Log.i("FragmentHelper", "Opened Home")
    }
}