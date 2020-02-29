package com.example.tusamaker.application


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tusamaker.R
import com.example.tusamaker.adapters.HomeEventsAdapter
import com.example.tusamaker.data.eventList
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent

class Home : Fragment(), KoinComponent {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerEventsAll)
        val ctx: Context by inject()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HomeEventsAdapter(
            arrayListOf(eventList[0], eventList[1], eventList[2]),
            ctx
        )


        return view
    }
}
