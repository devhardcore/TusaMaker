package com.example.omskalive.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.omskalive.Data.Event
import com.example.omskalive.R
import kotlinx.android.synthetic.main.card_event.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeEventsAdapter(private val events: ArrayList<Event>, private val context: Context) :
    RecyclerView.Adapter<HomeEventsAdapter.ViewHolder>(), KoinComponent {

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(view: ViewGroup, position: Int) = ViewHolder(
        LayoutInflater.from(view.context).inflate(
            R.layout.card_event,
            view,
            false
        )
    )

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        view.bind(
            events[position].type,
            events[position].name,
            events[position].price,
            events[position].date,
                events[position].dateShort
        )
        view.itemView.setOnClickListener {
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KoinComponent {
        private val eventName: TextView? = itemView.name
        private val eventDate: TextView? = itemView.date_event
        private val eventPrice: TextView? = itemView.price
        private val eventType: TextView? = itemView.type
        private val eventShortDate: TextView? = itemView.dateShort

        private val ctx: Context by inject()

        fun bind(type: String, name: String, price: String, date: String, dateShort: String) {
            eventName?.text = name
            eventDate?.text = date
            eventPrice?.text = price
            eventType?.text = type
            eventShortDate?.text = dateShort
            itemView.setBackgroundResource(R.drawable.rammstain)
        }
    }
}