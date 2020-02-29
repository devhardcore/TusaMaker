package com.example.tusamaker.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tusamaker.R
import com.example.tusamaker.data.EventModel
import kotlinx.android.synthetic.main.card_event.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class SelectionAdapter(private val events: ArrayList<EventModel>, private val context: Context) :
    RecyclerView.Adapter<SelectionAdapter.ViewHolder>(), KoinComponent {

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(view: ViewGroup, position: Int) = ViewHolder(
        LayoutInflater.from(view.context).inflate(
            R.layout.card_event,
            view,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("SelectionAdapter", "onBindViewHolder")
        holder.bind(
            events[position].category,
            events[position].title,
            "100p",
            events[position].date,
            "10"
        )
        holder.itemView.setOnClickListener {
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