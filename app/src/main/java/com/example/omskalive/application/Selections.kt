package com.example.omskalive.application


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omskalive.Data.Event
import com.example.omskalive.Data.Selection
import com.example.omskalive.Data.eventList
import com.example.omskalive.R
import com.example.omskalive.adapters.SelectionsAdapter

class Selections : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selections, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerSelections)

        if (context != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = SelectionsAdapter(
                arrayListOf(
                    Selection(arrayListOf(eventList[1], eventList[4], eventList[0], eventList[4]), "WOW!", "Today"),
                    Selection(arrayListOf(eventList[2], eventList[3], eventList[1], eventList[3]), "WOW!", "For You"),
                    Selection(arrayListOf(eventList[3], eventList[2], eventList[2], eventList[2]), "WOW!", "Popular"),
                    Selection(arrayListOf(eventList[0], eventList[1], eventList[3], eventList[1]), "WOW!", "Soon"),
                    Selection(arrayListOf(eventList[4], eventList[0], eventList[4], eventList[0]), "WOW!", "Fun!")
                ),
                context!!
            )
        }
        return view
    }
}
