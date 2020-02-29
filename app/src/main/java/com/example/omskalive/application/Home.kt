package com.example.omskalive.application


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omskalive.Data.Event
import com.example.omskalive.Data.eventList
import com.example.omskalive.R
import com.example.omskalive.adapters.HomeEventsAdapter
import org.koin.core.KoinComponent

class Home : Fragment(), KoinComponent {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerEventsAll)
        if (context != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = HomeEventsAdapter(
                arrayListOf(eventList[0], eventList[1], eventList[2], eventList[3], eventList[4]),
                context!!
            )
        }
        return view
    }
}
