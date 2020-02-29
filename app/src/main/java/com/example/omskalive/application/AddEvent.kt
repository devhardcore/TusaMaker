package com.example.omskalive.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omskalive.Data.Event
import com.example.omskalive.Data.Questions
import com.example.omskalive.R
import com.example.omskalive.adapters.AddEventAdapter
import com.example.omskalive.adapters.HomeEventsAdapter

class AddEvent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_event_layout, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.questionRecucler)

        if (context != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = AddEventAdapter(
                arrayListOf(
                    Questions("Event title", "Anime Festival"),
                    Questions("Type of event", "Rock Festival"),
                    Questions("Event Date", "23 February 2020"),
                    Questions("Start time", "9PM"),
                    Questions("Duration", "2 Hour"),
                    Questions("Ticket price", "10-60$"),
                    Questions("Location", "Omsk Pr.Mira 55/1")
                    ),
                context!!
            )
        }
        return view
    }
}